package com.api.postnet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SearchBadRequestException extends RuntimeException {
    public SearchBadRequestException(String message){
        super(message);
    }
}
