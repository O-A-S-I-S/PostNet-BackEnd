package com.api.tp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectPrescriptionRequestException extends RuntimeException {
    public IncorrectPrescriptionRequestException(String message){
        super(message);
    }
}