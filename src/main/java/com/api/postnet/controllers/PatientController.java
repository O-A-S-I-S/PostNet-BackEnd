package com.api.postnet.controllers;

import com.api.postnet.dto.MedicResponse;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import com.api.postnet.services.AppoimentService;
import com.api.postnet.services.MedicService;
import com.api.postnet.services.PatientService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    private EntityDtoConverter converter;
    public PatientController(PatientService patientService, EntityDtoConverter converter){
        this.patientService=patientService;
        this.converter=converter;
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicResponse> findMedicById(@PathVariable Long id){
        Patient patient=patientService.getPatientById(id);

        return new ResponseEntity(converter.convertEntityToDto(patient), HttpStatus.OK);
    }
}
