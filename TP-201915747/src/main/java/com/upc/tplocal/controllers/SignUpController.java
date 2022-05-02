package com.upc.tplocal.controllers;

import com.upc.tplocal.dto.LogInRequest;
import com.upc.tplocal.dto.LogInResponse;
import com.upc.tplocal.dto.SignUpRequest;
import com.upc.tplocal.dto.SignUpResponse;
import com.upc.tplocal.entities.Person;
import com.upc.tplocal.services.SignUpService;
import com.upc.tplocal.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SignUpController {

    private SignUpService signUpService;
    private EntityDtoConverter converter;

    public SignUpController(SignUpService signUpService, EntityDtoConverter converter) {
        this.signUpService = signUpService;
        this.converter = converter;
    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponse> fetchLogIn(@RequestBody LogInRequest request) {
        Person person = signUpService.fetchPerson(request);

        return new ResponseEntity<>(converter.convertLogEntityToDto(person), HttpStatus.FOUND);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> createSignUp(@RequestBody SignUpRequest request){
        Person person = signUpService.createPerson(request);

        return new ResponseEntity(converter.convertSignEntityToDto(person), HttpStatus.CREATED);
    }

}
