package com.api.postnet.services;

import com.api.postnet.dto.AppointmentRequest;
import com.api.postnet.dto.PrescriptionRequest;
import com.api.postnet.entities.Appointment;
import com.api.postnet.entities.Medicine;
import com.api.postnet.entities.Prescription;
import com.api.postnet.exceptions.MedicineNotFoundException;
import com.api.postnet.repository.AppointmentRepository;
import com.api.postnet.repository.MedicineRepository;
import com.api.postnet.repository.PrescriptionRepository;
import com.api.postnet.util.PrescriptionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
    private AppointmentRepository appointmentRepository;
    private MedicineRepository medicineRepository;

    PrescriptionService(PrescriptionRepository prescriptionRepository , AppointmentRepository appointmentRepository, MedicineRepository medicineRepository){
        this.prescriptionRepository=prescriptionRepository;
        this.appointmentRepository=appointmentRepository;
        this.medicineRepository=medicineRepository;
    }
    @Transactional(readOnly = true)
    public Prescription getPrescriptionById(Long id){
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
        List<Medicine> medicines=new ArrayList<>();

        prescriptionObj.setId(UUID.randomUUID().getMostSignificantBits());
        prescriptionObj.setDescription(prescriptionRequest.getDescription());


        return prescriptionObj;
    }



}