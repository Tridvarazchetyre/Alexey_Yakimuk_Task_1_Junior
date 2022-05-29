package com.interview.project.rest;

import com.interview.project.jpa.model.Node;
import com.interview.project.jpa.model.Storage;
import com.interview.project.rest.exceptions.DataNotFoundException;
import com.interview.project.rest.exceptions.IncorrectDataException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/rest")
public class CacheApi extends AbstractController{

    @Inject
    private Storage storage;

    @GetMapping("/get/{key}")
    public ResponseEntity<?> getValue(@PathVariable String key) throws DataNotFoundException{
        Node value = storage.getStorage().get(key);

        if (value == null){
            throw new DataNotFoundException("Key " + key + " is not exist in memory");
        }

        return ResponseEntity.ok(storage.getStorage().get(key).getValue());
    }


    @RequestMapping("/set")
    public ResponseEntity<?> setValue(@RequestParam(defaultValue = "STRING") Node.Type type, @RequestBody Node<?> node) throws IncorrectDataException{

        if(!node.isCorrect()){
            throw new IncorrectDataException("Request body haven't key or value");
        }

        switch (type){
            case HASH:
                if(!(node.getValue() instanceof Map)){
                    throw new IncorrectDataException("The value must match the MAP format");
                }
                break;
            case LIST:
                if(!(node.getValue() instanceof List)){
                    throw new IncorrectDataException("The value must match the LIST format");
                }
                break;
            default:
                if(!(node.getValue() instanceof String || node.getValue() instanceof Integer)){
                    throw new IncorrectDataException("The value must match the STRING format");
                }
                break;
        }

        storage.getStorage().put(node.getKey(), node);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/del/{key}")
    public ResponseEntity<Node> delValue(@PathVariable String key) throws DataNotFoundException{
        Node value = storage.getStorage().get(key);

        if (value == null){
            throw new DataNotFoundException("Key " + key + " is not exist in memory");
        }

        return ResponseEntity.ok(storage.getStorage().remove(key));
    }

    @GetMapping("/keys")
    public ResponseEntity<Set<String>> getKeys() {
        return ResponseEntity.ok(storage.getStorage().keySet());
    }

}
