package com.oasis.postnet.services;

import com.oasis.postnet.entities.Medic;
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

        //incorporate rollback in case of failure
        @Transactional(readOnly = true)
        public Medic getMedicByDni(String dni){
            return medicRepository.findMedicByDni(dni);
        }

        @Transactional(readOnly = true)
        public List<Medic> getAllMedics(){
            return medicRepository.getAllMedics();
        }

}
