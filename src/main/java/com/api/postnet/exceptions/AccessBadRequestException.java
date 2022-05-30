package com.api.postnet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AccessBadRequestException extends RuntimeException{
    public AccessBadRequestException(String message){
        super(message);
    }
}