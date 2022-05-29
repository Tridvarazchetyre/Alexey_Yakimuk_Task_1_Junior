package com.interview.project.rest;

import com.interview.project.jpa.model.Node;
import com.interview.project.jpa.model.Storage;
import com.interview.project.rest.dto.Response;
import com.interview.project.rest.exceptions.DataNotFoundException;
import com.interview.project.rest.exceptions.IncorrectDataException;
import com.interview.project.services.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/rest/storage")
public class CacheApi extends AbstractController{

    @Autowired
    private Storage storage;


    @GetMapping("/get/{key}")
    public ResponseEntity<?> getValue(@PathVariable String key) throws DataNotFoundException{
        Node value = storage.get(key);

        if (value == null){
            throw new DataNotFoundException("Key " + key + " is not exist in memory");
        }

        return ResponseEntity.ok(value);
    }


    @PostMapping("/set")
    public ResponseEntity<?> setValue(@RequestParam(defaultValue = "STRING") Node.Type type, @RequestBody Node<?> node) throws IncorrectDataException{

        if(!node.isCorrect()){
            throw new IncorrectDataException("Request body haven't key or value");
        }

        System.out.println(ControllerService.validTypeItem(type, node));

        storage.put(node);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/del/{key}")
    public ResponseEntity<Response> delValue(@PathVariable String key) throws DataNotFoundException{

        if (!storage.remove(key)){
            throw new DataNotFoundException("Key " + key + " is not exist in memory");
        }

        return ResponseEntity.ok(new Response("OK", 200));
    }

    @GetMapping("/keys")
    public ResponseEntity<Set<String>> getKeys() {
        return ResponseEntity.ok(storage.getKeys());
    }

}
