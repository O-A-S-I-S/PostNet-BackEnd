package com.api.postnet.services;

import com.api.postnet.dto.PrescriptionRequest;
import com.api.postnet.entities.Appointment;
import com.api.postnet.entities.Prescription;
import com.api.postnet.repository.PrescriptionRepository;
import com.api.postnet.util.PrescriptionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
   // private AppointmentRepository appointmentRepository;

    PrescriptionService(PrescriptionRepository prescriptionRepository/* ,
                       AppointmentRepository appointmentRepository*/){
        this.prescriptionRepository=prescriptionRepository;
        //this.appointmentRepository=appointmentRepository;
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
       /* Appointment appointment=appointmentRepository.findById(prescriptionObj.getAppointment().getId())
                        .orElseThrow(()->new AppointmentNotFoundException("Appointment no existe"));*/
        prescriptionObj.setId(UUID.randomUUID().getMostSignificantBits());
       // prescriptionObj.setAppointment(appointment);
        prescriptionObj.setDescription(prescriptionRequest.toString());
        return prescriptionObj;
    }
}