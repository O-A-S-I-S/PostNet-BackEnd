package com.api.postnet.controllers;

import com.api.postnet.dto.LogInRequest;
import com.api.postnet.dto.LogInResponse;
import com.api.postnet.dto.PatientRequest;
import com.api.postnet.dto.PatientResponse;
import com.api.postnet.entities.Patient;
import com.api.postnet.services.PatientService;
import com.api.postnet.util.EntityDtoConverter;
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

    @GetMapping("/log_in")
    public ResponseEntity<LogInResponse> getPatientByDniAndPassword(@Valid @RequestBody LogInRequest logInRequest) {

        return new ResponseEntity(converter.convertPatientToLogInDto(patientService.findPatientByDniAndPassword(logInRequest.getDni(), logInRequest.getPassword())), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<PatientResponse> createPatient(@Valid @RequestBody PatientRequest patientRequest){
        Patient patient = patientService.createPatient(patientRequest);
        return new ResponseEntity<>(converter.convertPatientToDto(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<PatientResponse> deletePatient(@PathVariable String dni){

        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
