package com.interview.project.rest;

import com.interview.project.rest.exceptions.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController {

    @ExceptionHandler(RestException.class)
    private ResponseEntity.BodyBuilder handlerException(RestException e){
        return ResponseEntity.status(e.statusCode());
    }
}
