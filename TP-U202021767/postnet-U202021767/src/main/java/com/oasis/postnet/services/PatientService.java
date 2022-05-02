package com.oasis.postnet.services;

import com.oasis.postnet.entities.Medic;
import com.oasis.postnet.entities.Patient;
import com.oasis.postnet.repository.MedicRepository;
import com.oasis.postnet.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PatientService {
        private PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository){
            this.patientRepository = patientRepository;
        }

        //incorporate rollback in case of failure
        @Transactional(readOnly = true)
        public Patient getPatientByDni(String dni){
            return patientRepository.findPatientByDni(dni);
        }

        @Transactional(readOnly = true)
        public List<Patient> getAllPatients(){
            return patientRepository.getAllPatients();
        }

}
