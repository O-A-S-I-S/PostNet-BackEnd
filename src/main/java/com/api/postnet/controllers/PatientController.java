package com.api.postnet.controllers;

import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.entities.Prescription;
import com.api.postnet.services.PatientService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;
    private EntityDtoConverter converter;

    public PatientController(PatientService patientService, EntityDtoConverter converter){
        this.patientService = patientService;
        this.converter = converter;
    }

    @GetMapping("/{patientId}/{appoimentId}")
    public ResponseEntity<List<PrescriptionResponse>> findPrescriptionsById(@PathVariable Long patientId,@PathVariable Long appoimentId){
        List<Prescription> prescriptions = patientService.findPatientPrescription(patientId ,appoimentId);
        return new ResponseEntity(converter.convertPrescriptionToDto(prescriptions), HttpStatus.OK);
    }
}
