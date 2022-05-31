package com.api.postnet.controllers;

import com.api.postnet.dto.*;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Prescription;
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

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<PatientResponse> deletePatient(@PathVariable String dni){

        return new ResponseEntity<>(HttpStatus.GONE);
    }
    @GetMapping("/{dni}")
    public ResponseEntity<MedicResponse> findPatientByDni(@PathVariable String dni){
        Patient patient=patientService.getPatientByDni(dni);

        return new ResponseEntity(converter.convertPatientToDto(patient), HttpStatus.OK);
    }

    @GetMapping("/getAll/{dni}")
    public ResponseEntity<List<PrescriptionResponse>> getAllPrescriptionsByDni(@PathVariable String dni)
    {
        List<Prescription> prescriptions = patientService.getAllPrescriptionsByDni(dni);
        return new ResponseEntity(converter.convertPrescriptionToDto(prescriptions), HttpStatus.OK);
    }
}
