package com.oasis.postnet.services;

import com.oasis.postnet.dto.PatientRequest;
import com.oasis.postnet.dto.PatientResponse;
import com.oasis.postnet.entities.Patient;
import com.oasis.postnet.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    @Transactional(readOnly = true)
    public List<Patient> getPatientsByBloodType(String bloodType) {
        return patientRepository.getPatientsByBloodType(bloodType);
    }

    //incorporate rollback in case of failure
    @Transactional(readOnly = true)
    public Patient getPatientByDni(String dni) {
        return patientRepository.findPatientByDni(dni);
    }

    @Transactional(readOnly = true)
    public Patient findPatientByDniAndPassword(String dni, String password) {
        return patientRepository.findPatientByDniAndPassword(dni, password);
    }

    @Transactional
    public Patient createPatient(PatientRequest patientRequest) {
        Patient patientNew = initPatient(patientRequest);
        return patientRepository.save(patientNew);
    }

    private Patient initPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setDni(patientRequest.getDni());
        patient.setSurName(patientRequest.getSurName());
        patient.setLastName(patientRequest.getLastName());
        patient.setEmail(patientRequest.getEmail());
        patient.setTelephone(patientRequest.getTelephone());
        patient.setCellphone(patientRequest.getCellphone());
        patient.setBirthDate(patientRequest.getBirthDate());
        patient.setBloodType(patientRequest.getBloodType());

        return patient;
    }
}
