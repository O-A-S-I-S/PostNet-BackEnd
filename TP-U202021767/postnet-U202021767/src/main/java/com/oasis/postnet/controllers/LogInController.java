package com.oasis.postnet.controllers;

import com.oasis.postnet.dto.LogInResponse;
import com.oasis.postnet.entities.Person;
import com.oasis.postnet.services.LogInService;
import com.oasis.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logIn")
public class LogInController {
    private LogInService logInService;
    private EntityDtoConverter converter;

    public LogInController(LogInService logInService, EntityDtoConverter converter){
        this.logInService = logInService;
        this.converter = converter;
    }

    @GetMapping("/{username}")
    public ResponseEntity<LogInResponse> getPersonByDni(@PathVariable String dni){
        Person person = logInService.findPersonByDni(dni);

        return new ResponseEntity(converter.convertPersonToDto(person), HttpStatus.OK);
    }
}
