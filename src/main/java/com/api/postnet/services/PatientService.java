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
<<<<<<< HEAD
    public Patient getPatientByDni(String patientDni){
        return patientRepository.findPatientByDni(patientDni);
=======
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
>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
    }
}
