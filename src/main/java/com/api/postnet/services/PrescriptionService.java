package com.api.postnet.services;

import com.api.postnet.dto.PrescriptionRequest;
import com.api.postnet.entities.Appointment;
import com.api.postnet.entities.Prescription;
import com.api.postnet.repository.AppoimentRepository;
import com.api.postnet.repository.PrescriptionRepository;
import com.api.postnet.util.PrescriptionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
   private AppoimentRepository appointmentRepository;

    PrescriptionService(PrescriptionRepository prescriptionRepository ,
                       AppoimentRepository appointmentRepository){
        this.prescriptionRepository=prescriptionRepository;
        this.appointmentRepository=appointmentRepository;
    }
    @Transactional(readOnly = true)
    public Prescription getPrescriptionById(Integer id){
        return prescriptionRepository.findPrescriptionByIdNativeSQL(id);
    }
    @Transactional
    public Prescription createPrescription(PrescriptionRequest prescriptionRequest){
       PrescriptionValidator.validatePrescription(prescriptionRequest);
        Prescription prescriptionNew=initPrescription(prescriptionRequest);
        return prescriptionRepository.save(prescriptionNew);
    }
    private Prescription initPrescription(PrescriptionRequest prescriptionRequest){
        Prescription prescriptionObj=new Prescription();
        prescriptionObj.setId(UUID.randomUUID().getMostSignificantBits());
        prescriptionObj.setAppointment(this.appointmentRepository.findAppoimentByAppoimentId(prescriptionRequest.getAppointment_id()));


        prescriptionObj.setDescription(prescriptionRequest.getDescription());
        return prescriptionObj;
    }
}