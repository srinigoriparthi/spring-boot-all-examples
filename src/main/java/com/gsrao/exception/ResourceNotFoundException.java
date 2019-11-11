package com.gsrao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException {

    public ResourceNotFoundException(String id){
        super("Person not Found:"+id);
    }
}
