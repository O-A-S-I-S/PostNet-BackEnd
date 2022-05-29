package com.oasis.postnet.controllers;

import com.oasis.postnet.dto.*;
import com.oasis.postnet.entities.Patient;
import com.oasis.postnet.services.PatientService;
import com.oasis.postnet.util.BloodType;
import com.oasis.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    private EntityDtoConverter converter;

    public PatientController(PatientService patientService, EntityDtoConverter converter) {
        this.patientService = patientService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients(){
        return new ResponseEntity(converter.convertPatientToDto(patientService.getAllPatients()), HttpStatus.OK);
    }

    @GetMapping("/blood_type/{bloodType}")
    public ResponseEntity<List<PatientResponse>> getPatientsByBloodType(@PathVariable String bloodType) {

        return new ResponseEntity<>(converter.convertPatientToDto(patientService.getPatientsByBloodType(bloodType)), HttpStatus.OK);
    }
}
