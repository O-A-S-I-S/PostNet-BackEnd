package com.api.postnet.services;

import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Prescription;
import com.api.postnet.repository.MedicRepository;
import com.api.postnet.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MedicService {
    private MedicRepository medicRepository;
    private PrescriptionRepository prescriptionRepository;

    public MedicService(MedicRepository medicRepository,PrescriptionRepository prescriptionRepository){
        this.medicRepository=medicRepository;
        this.prescriptionRepository=prescriptionRepository;
    }
    @Transactional
    public Medic getMedicByDni(String medicDni){
        return medicRepository.findMedicByDni(medicDni);
    }

    public List<Prescription> findPatientPrescriptions(Long patientId){
        return prescriptionRepository.findPrescriptionsByPatientId(patientId);
    }


}
