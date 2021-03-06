package com.api.postnet.services;

import com.api.postnet.dto.PatientRequest;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Prescription;
import com.api.postnet.exceptions.AccessBadRequestException;
import com.api.postnet.repository.PatientRepository;
import com.api.postnet.repository.PrescriptionRepository;
import com.api.postnet.util.BloodType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    private PrescriptionRepository prescriptionRepository;

    public PatientService(PatientRepository patientRepository, PrescriptionRepository prescriptionRepository) {
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Transactional(readOnly = true)
    public Page<Patient> getAllPatients(Pageable pageable) {
        return patientRepository.getAllPatients(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Patient> getPatientsByNameContaining(String name, Pageable pageable){ return patientRepository.getPatientsBySurnameContainingOrLastNameContaining(name, name, pageable);}

    @Transactional(readOnly = true)
    public Page<Patient> getPatientsByBloodType(String bloodType, Pageable pageable) {
        return patientRepository.getPatientsByBloodType(bloodType, pageable);
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
        patient.setSurname(patientRequest.getSurname());
        patient.setLastName(patientRequest.getLastName());
        patient.setEmail(patientRequest.getEmail());
        patient.setTelephone(patientRequest.getTelephone());
        patient.setCellphone(patientRequest.getCellphone());
        patient.setBirthDate(patientRequest.getBirthDate());
        patient.setPassword(patientRequest.getPassword());
        patient.setBloodType(BloodType.valueOf(patientRequest.getBloodType()));

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

    @Transactional(readOnly = true)
    public List<Prescription> getAllPrescriptionsByDni(String dni) {
        return prescriptionRepository.findPrescriptionsByPatientId(dni);
    }
}
