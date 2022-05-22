package com.interview.project.rest.exceptions;

public class IncorrectDataException extends RestException {

    private static int statusCode = 500;

    public IncorrectDataException(String msg) {
        super(msg);
    }

    public int statusCode() {
        return statusCode;
    }
}
