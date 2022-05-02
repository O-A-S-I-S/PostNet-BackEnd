package com.api.tp.service;

import com.api.tp.dto.PrescriptionRequest;
import com.api.tp.entity.Prescription;
import com.api.tp.repository.PrescriptionRepository;
import com.api.tp.util.PrescriptionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
    PrescriptionService(PrescriptionRepository prescriptionRepository){
        this.prescriptionRepository=prescriptionRepository;
    }
    @Transactional(readOnly = true)
    public Prescription getPrescriptionById(Integer id){
        return prescriptionRepository.findPrescriptionById(id);
    }
    /*public Prescription createPrescription(PrescriptionRequest prescriptionRequest){
        PrescriptionValidator.validatePrescription((prescriptionRequest));
        Prescription prescriptionNew=init
    }

    private Prescription initPrescription(PrescriptionRequest prescriptionRequest){
        Prescription prescription=new Prescription();
        List<>
    }*/
}
