package com.api.postnet.handler;

import com.api.postnet.exceptions.IncorrectPrescriptionRequestException;
import com.api.postnet.exceptions.PrescriptionNotFoundException;
import com.api.postnet.exceptions.PrescriptionServiceExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class PrescriptionServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request){
        PrescriptionServiceExceptionResponse response = new PrescriptionServiceExceptionResponse(exception.getMessage(),request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response,response.getStatus());
    }
    @ExceptionHandler(IncorrectPrescriptionRequestException.class)
    public ResponseEntity<Object>handlerIncorrectRequest(IncorrectPrescriptionRequestException exception, WebRequest request){
        PrescriptionServiceExceptionResponse response = new PrescriptionServiceExceptionResponse(exception.getMessage(),request.getDescription(false), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response,response.getStatus());
    }
    @ExceptionHandler(PrescriptionNotFoundException.class)
    public ResponseEntity<Object>handlerIncorrectRequest(PrescriptionNotFoundException exception, WebRequest request){
        PrescriptionServiceExceptionResponse response = new PrescriptionServiceExceptionResponse(exception.getMessage(),request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response,response.getStatus());
    }
}
