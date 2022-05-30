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
<<<<<<< HEAD
=======

    @Transactional(readOnly = true)
    public List<Medic> getAllMedics() {
        return medicRepository.getAllMedics();
    }

    @Transactional(readOnly = true)
    public List<Medic> getMedicsBySpecialty(String specialty) {
        List<Medic> medics = medicRepository.getMedicsBySpecialty(specialty);
        if(medics.isEmpty()) throw new SearchBadRequestException("La especialidad ingresada no existe");
        else return medics;
    }

    //incorporate rollback in case of failure
    @Transactional(readOnly = true)
    public Medic getMedicByDni(String dni) {
        return medicRepository.findMedicByDni(dni);
    }

    @Transactional(readOnly = true)
    public Medic findMedicByDniAndPassword(String dni, String password) {
        return medicRepository.findMedicByDniAndPassword(dni, password);
    }

>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
    @Transactional
    public Medic getMedicByDni(String medicDni){
        return medicRepository.findMedicByDni(medicDni);
    }
}
