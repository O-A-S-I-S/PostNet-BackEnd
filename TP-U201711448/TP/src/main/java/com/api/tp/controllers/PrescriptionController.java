package com.api.tp.controllers;

import com.api.tp.dto.PrescriptionRequest;
import com.api.tp.dto.PrescriptionResponse;
import com.api.tp.entity.Prescription;
import com.api.tp.service.PrescriptionService;
import com.api.tp.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private PrescriptionService prescriptionService;
    private EntityDtoConverter converter;
    public PrescriptionController(PrescriptionService prescriptionService, EntityDtoConverter converter){
        this.prescriptionService=prescriptionService;
        this.converter=converter;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PrescriptionResponse> findPrescriptionById(@PathVariable Integer Id){
        Prescription prescription=prescriptionService.getPrescriptionById(Id);
        return new ResponseEntity(converter.convertEntityToDto(prescription), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PrescriptionResponse> createPrescription(@RequestBody PrescriptionRequest request){
        Prescription prescription= prescriptionService.createPrescription(request);
        return new ResponseEntity(converter.convertEntityToDto(prescription), HttpStatus.CREATED);
    }


}
