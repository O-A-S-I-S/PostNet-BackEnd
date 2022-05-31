package com.api.postnet.services;

import com.api.postnet.dto.PatientRequest;
import com.api.postnet.entities.Patient;
import com.api.postnet.exceptions.AccessBadRequestException;
import com.api.postnet.repository.PatientRepository;
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
        if(patientRepository.findPatientsByDniAndPassword(dni, password).isEmpty())
            throw new AccessBadRequestException("Credenciales incorrectas");
        else{
            return patientRepository.findPatientByDniAndPassword(dni, password);
        }
    }

    @Transactional
    public Patient createPatient(PatientRequest patientRequest) {
        if(!patientRepository.findPatientsByDni(patientRequest.getDni()).isEmpty())
            throw new AccessBadRequestException("Ya existe un usuario con el mismo DNI");
        else{
            Patient patientNew = initPatient(patientRequest);
            return patientRepository.save(patientNew);
        }
    }

    private Patient initPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setDni(patientRequest.getDni());
        patient.setSurname(patientRequest.getSurName());
        patient.setLastName(patientRequest.getLastName());
        patient.setEmail(patientRequest.getEmail());
        patient.setTelephone(patientRequest.getTelephone());
        patient.setCellphone(patientRequest.getCellphone());
        patient.setBirthDate(patientRequest.getBirthDate());
        patient.setPassword(patientRequest.getPassword());
        patient.setBloodType(patientRequest.getBloodType());

        return patient;
    }

    @Transactional
    public void deletePatient(String dni){
        try{
            patientRepository.deleteById(patientRepository.findPatientByDni(dni).getId());
        } catch (Exception e){
            throw new AccessBadRequestException("DNI incorrecto o el paciente no existe");
        }
    }
}
