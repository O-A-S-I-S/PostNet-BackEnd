package com.api.postnet.controllers;

import com.api.postnet.dto.AppoimentRequest;
import com.api.postnet.dto.AppoimentResponse;
import com.api.postnet.entities.Appoiment;
import com.api.postnet.services.AppoimentService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
public class AppoimentController {
    private AppoimentService appoimentService;
    private EntityDtoConverter converter;
    public AppoimentController(AppoimentService appoimentService, EntityDtoConverter converter){
        this.appoimentService=appoimentService;
        this.converter=converter;
    }

    @PostMapping
    public ResponseEntity<AppoimentResponse> createAppoiment(@RequestBody AppoimentRequest request){
        Appoiment appoiment=appoimentService.createAppoiment(request);
        return new ResponseEntity<>(converter.convertEntityToDto(appoiment),HttpStatus.CREATED);
    }

}