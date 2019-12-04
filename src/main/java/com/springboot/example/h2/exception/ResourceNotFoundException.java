package com.springboot.example.h2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 3829117951619249057L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
