package com.oasis.postnet.services;

import com.oasis.postnet.dto.MedicRequest;
import com.oasis.postnet.dto.PatientRequest;
import com.oasis.postnet.entities.Medic;
import com.oasis.postnet.entities.Patient;
import com.oasis.postnet.repository.MedicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Allows framework to take control of life cycle
@Service
public class MedicService {

        private MedicRepository medicRepository;

        public MedicService(MedicRepository medicRepository){
            this.medicRepository = medicRepository;
        }

        @Transactional(readOnly = true)
        public List<Medic> getAllMedics(){
            return medicRepository.getAllMedics();
        }

        @Transactional(readOnly = true)
        public List<Medic> getMedicsBySpecialty(String specialty){ return medicRepository.getMedicsBySpecialty(specialty); }

}
