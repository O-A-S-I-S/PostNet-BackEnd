package com.api.postnet.controllers;

import com.api.postnet.dto.PrescriptionRequest;
import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.entities.Prescription;
import com.api.postnet.services.PrescriptionService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private PrescriptionService prescriptionService;
    private EntityDtoConverter converter;
    public PrescriptionController(PrescriptionService prescriptionService, EntityDtoConverter converter){
        this.prescriptionService=prescriptionService;
        this.converter=converter;
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionResponse> findPrescriptionById(@PathVariable Integer prescriptionId){
        Prescription prescription=prescriptionService.getPrescriptionById(prescriptionId);
        return new ResponseEntity(converter.convertEntityToDto(prescription), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PrescriptionResponse> createPrescription(@RequestBody PrescriptionRequest request){
        Prescription prescription= prescriptionService.createPrescription(request);
        return new ResponseEntity(converter.convertEntityToDto(prescription), HttpStatus.CREATED);
    }


}
