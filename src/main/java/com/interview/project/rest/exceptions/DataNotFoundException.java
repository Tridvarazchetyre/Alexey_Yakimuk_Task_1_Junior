package com.interview.project.rest.exceptions;

public class DataNotFoundException extends RestException {

    private static final int STATUS_CODE = 404;

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public int statusCode() {
        return STATUS_CODE;
    }
}
