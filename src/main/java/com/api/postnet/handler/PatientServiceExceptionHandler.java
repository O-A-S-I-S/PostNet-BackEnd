package com.api.postnet.handler;

import com.api.postnet.exceptions.AppointmentNotFoundException;
import com.api.postnet.exceptions.IncorrectAppointmentRequestException;
import com.api.postnet.exceptions.PatientServiceExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class PatientServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request){
        PatientServiceExceptionResponse response = new PatientServiceExceptionResponse(exception.getMessage(),
                request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(IncorrectAppointmentRequestException.class)
    public ResponseEntity<Object> handleIncorrectRequest(IncorrectAppointmentRequestException exception, WebRequest request){
        PatientServiceExceptionResponse response = new PatientServiceExceptionResponse(exception.getMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public  ResponseEntity<Object> handleAppointmentNotFoundException(AppointmentNotFoundException exception, WebRequest request){
        PatientServiceExceptionResponse response = new PatientServiceExceptionResponse(exception.getMessage(),
                request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

}
