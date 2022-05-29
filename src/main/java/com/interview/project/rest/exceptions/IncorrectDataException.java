package com.interview.project.rest.exceptions;

public class IncorrectDataException extends RestException {

    private static final int STATUS_CODE = 500;

    public IncorrectDataException(String msg) {
        super(msg);
    }

    public int statusCode() {
        return STATUS_CODE;
    }
}
