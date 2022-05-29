package com.interview.project.jpa.model;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Storage {

    private Map<String, Node> storage;

    public Map<String, Node> getStorage() {
        if(storage == null){
            storage = new HashMap<>();
        }

        return storage;
    }
}
