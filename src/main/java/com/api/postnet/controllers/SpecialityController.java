package com.api.postnet.controllers;

import com.api.postnet.dto.SpecialityRequest;
import com.api.postnet.dto.SpecialityResponse;
import com.api.postnet.entities.Speciality;
import com.api.postnet.services.SpecialityService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {
    private SpecialityService specialityService;
    private EntityDtoConverter converter;
    public SpecialityController(SpecialityService specialityService, EntityDtoConverter converter){
        this.specialityService=specialityService;
        this.converter=converter;
    }

    @GetMapping("/{name}")
    public ResponseEntity<SpecialityResponse> findSpecialityByName(@PathVariable String name){

        return new ResponseEntity<>(converter.convertEntityToDto(specialityService.getSpecialityByName(name )), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SpecialityResponse> createSpeciality(@RequestBody SpecialityRequest specialityRequest){
        Speciality speciality = specialityService.createSpeciality(specialityRequest);
        return new ResponseEntity<>(converter.convertEntityToDto(speciality), HttpStatus.CREATED);
    }
}
