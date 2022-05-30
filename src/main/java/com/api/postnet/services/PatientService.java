package com.api.postnet.services;


import com.api.postnet.entities.Patient;
import com.api.postnet.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){this.patientRepository=patientRepository;}


    @Transactional
    public Patient getPatientByDni(String patientDni){
        return patientRepository.findPatientByDni(patientDni);
    }
}
