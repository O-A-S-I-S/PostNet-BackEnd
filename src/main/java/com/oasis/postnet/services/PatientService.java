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

        public PatientService(PatientRepository patientRepository){
            this.patientRepository = patientRepository;
        }

        @Transactional(readOnly = true)
        public List<Patient> getAllPatients(){
            return patientRepository.getAllPatients();
        }

        @Transactional(readOnly = true)
        public List<Patient> getPatientsByBloodType(String bloodType){
             return patientRepository.getPatientsByBloodType(bloodType);
         }

}
