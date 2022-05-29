package com.interview.project.rest.exceptions;

public class DataNotFoundException extends RestException {

    private static int statusCode = 404;

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public int statusCode() {
        return statusCode;
    }
}
