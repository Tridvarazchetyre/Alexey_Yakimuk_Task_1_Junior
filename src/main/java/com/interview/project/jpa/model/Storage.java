package com.interview.project.jpa.model;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class Storage {

    private List<Node> storage;

    public Storage(){
        storage = new ArrayList<>();
    }

    public boolean put(Node newItem){
        String key = newItem.getKey();

        if(containKey(key)){
            return false;
        }
        storage.add(newItem);

        return true;
    }

    public Node get(String key){
        return storage.stream()
                .filter((e) -> e.getKey().equals(key))
                .findAny().get();
    }

    public boolean remove(String key){
        boolean successRemove = false;

        for(Node item : storage){
            if(key.equals(item.getKey())){
                storage.remove(item);
                successRemove = true;
                break;
            }
        }

        return successRemove;
    }

    public Set<String> getKeys(){
        return storage.stream().map(Node::getKey).collect(Collectors.toSet());
    }
    private boolean containKey(String key){
        return storage.stream().anyMatch((e) -> e.getKey().equals(key));
    }

}
