package com.api.postnet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.CONFLICT)
public class MedicDniDuplicatedException extends  RuntimeException{
    public MedicDniDuplicatedException(String message){
        super(message);
    }
}
