package com.api.postnet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectAppointmentRequestException extends RuntimeException{
    public IncorrectAppointmentRequestException(String message){
        super(message);
    }
}
