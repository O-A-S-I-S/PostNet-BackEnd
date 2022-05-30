package com.api.postnet.services;

import com.api.postnet.dto.MedicRequest;
import com.api.postnet.entities.Medic;
import com.api.postnet.repository.MedicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Allows framework to take control of life cycle
@Service
public class MedicService {

    private MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Transactional(readOnly = true)
    public List<Medic> getAllMedics() {
        return medicRepository.getAllMedics();
    }

    @Transactional(readOnly = true)
    public List<Medic> getMedicsBySpecialty(String specialty) {
        return medicRepository.getMedicsBySpecialty(specialty);
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

    @Transactional
    public Medic createMedic(MedicRequest medicRequest) {
        Medic medicNew = initMedic(medicRequest);
        return medicRepository.save(medicNew);
    }

    private Medic initMedic(MedicRequest medicRequest) {
        Medic medic = new Medic();
        medic.setDni(medicRequest.getDni());
        medic.setSurname(medicRequest.getSurName());
        medic.setLastName(medicRequest.getLastName());
        medic.setEmail(medicRequest.getEmail());
        medic.setTelephone(medicRequest.getTelephone());
        medic.setCellphone(medicRequest.getCellphone());
        medic.setBirthDate(medicRequest.getBirthDate());

        return medic;
    }
}
