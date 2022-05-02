package com.api.postnet.controllers;

import com.api.postnet.dto.SignUpRequest;
import com.api.postnet.dto.SignUpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "api/v1/signups")
public class SignUpController {

    @GetMapping
    public ResponseEntity<List<SignUpResponse>> findAll()
    {
        List<SignUpResponse> signups = new ArrayList<>();

        SignUpResponse response_01 = new SignUpResponse();

        response_01.setId("test_id");
        response_01.setStatus("PENDING");
        response_01.setAccountId("test_patient_id");

        signups.add(response_01);

        return new ResponseEntity<>(signups, HttpStatus.OK);
    }

}
