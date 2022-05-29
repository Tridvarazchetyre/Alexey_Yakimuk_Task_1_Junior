package com.interview.project.jpa.model;

public class Node<T> {

    private String key;
    private T value;

    public Node(String key, T value){
        this.key = key;
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isCorrect(){
        return key != null && value != null;
    }


    public enum Type {
        LIST, HASH, STRING
    }
}


