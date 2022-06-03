package com.api.postnet.controllers;

import com.api.postnet.dto.*;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Prescription;
import com.api.postnet.services.PatientService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
//@CrossOrigin(origins = "http://localhost:4200/")
public class PatientController {
    private PatientService patientService;
    private EntityDtoConverter converter;

    public PatientController(PatientService patientService, EntityDtoConverter converter) {
        this.patientService = patientService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAllPatients(@RequestParam(required = false) String name,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "3") int size){
        Pageable paging = PageRequest.of(page, size);
        Page<Patient> pagePatients;

        if (name == null)
            pagePatients = patientService.getAllPatients(paging);
        else
            pagePatients = patientService.getPatientsByNameContaining(name, paging);

        List<PatientResponse> patients = converter.convertPatientToDto(pagePatients.getContent());

        Map<String, Object> response = new HashMap<>();
        response.put("patients", patients);
        response.put("currentPage", pagePatients.getNumber());
        response.put("totalItems", pagePatients.getTotalElements());
        response.put("totalPage", pagePatients.getSize());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/blood_type/{bloodType}")
    public ResponseEntity<Map<String,Object>> getPatientsByBloodType(@PathVariable String bloodType,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "3") int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Patient> pagePatients = patientService.getPatientsByBloodType(bloodType, paging);

        List<PatientResponse> patients = converter.convertPatientToDto(pagePatients.getContent());

        Map<String, Object> response = new HashMap<>();
        response.put("patients", patients);
        response.put("currentPage", pagePatients.getNumber());
        response.put("totalItems", pagePatients.getTotalElements());
        response.put("totalPage", pagePatients.getSize());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<PatientResponse> createPatient(@Valid @RequestBody PatientRequest patientRequest){
        Patient patient = patientService.createPatient(patientRequest);
        return new ResponseEntity<>(converter.convertPatientToDto(patient), HttpStatus.CREATED);
    }
    @DeleteMapping("/{dni}")
    public ResponseEntity<PatientResponse> deletePatient(@PathVariable String dni){
        patientService.deletePatient(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
