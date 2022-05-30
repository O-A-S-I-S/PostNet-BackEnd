package com.api.postnet.services;

import com.api.postnet.entities.Medic;
import com.api.postnet.repository.MedicRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MedicService {
    private MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository){
        this.medicRepository=medicRepository;
    }
    @Transactional
    public Medic getMedicByDni(String medicDni){
        return medicRepository.findMedicByDni(medicDni);
    }
}
