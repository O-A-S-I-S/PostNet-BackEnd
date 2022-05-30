 package com.oasis.postnet.exception;

 import com.fasterxml.jackson.annotation.JsonFormat;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import org.springframework.http.HttpStatus;
 import org.springframework.web.bind.annotation.ResponseStatus;

 import java.time.LocalDateTime;

@Data
@AllArgsConstructor
 public class GenericExceptionResponse {
     public String message;
     public String details;
     private HttpStatus status;
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
     private LocalDateTime timeStamp;
 }
