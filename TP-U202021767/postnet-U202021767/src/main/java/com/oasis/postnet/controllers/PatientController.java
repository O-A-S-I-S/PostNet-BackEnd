package com.oasis.postnet.controllers;

import com.oasis.postnet.services.PatientService;
import com.oasis.postnet.util.EntityDtoConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    private EntityDtoConverter entityDtoConverter;

    public PatientController(PatientService patientService, EntityDtoConverter entityDtoConverter){
        this.patientService = patientService;
        this.entityDtoConverter = entityDtoConverter;
    }

}
