package com.interview.project.rest.exceptions;

public abstract class RestException extends Exception{

    private static int statusCode;
    private String message;

    public RestException() {
        super();
    }

    public RestException(String msg) {
        super(msg);
        this.message = msg;
    }

    public int statusCode(){
        return statusCode;
    }

}
