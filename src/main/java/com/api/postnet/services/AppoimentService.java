package com.api.postnet.services;

import com.api.postnet.dto.AppoimentRequest;
import com.api.postnet.entities.Appointment;
import com.api.postnet.repository.AppoimentRepository;
import com.api.postnet.repository.MedicRepository;
import com.api.postnet.repository.PatientRepository;
import com.api.postnet.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AppoimentService {
    private AppoimentRepository appoimentRepository;

    private MedicRepository medicRepository;
    private PatientRepository patientRepository;
    private PaymentMethodRepository paymentMethodRepository;
    public AppoimentService(AppoimentRepository appoimentRepository, MedicRepository medicRepository, PatientRepository patientRepository, PaymentMethodRepository paymentMethodRepository){
        this.appoimentRepository=appoimentRepository;
        this.medicRepository=medicRepository;
        this.paymentMethodRepository=paymentMethodRepository;
        this.patientRepository=patientRepository;
    }

    @Transactional
    public Appointment getAppoimentById(Long appoimentid){
        return appoimentRepository.findAppoimentByAppoimentId(appoimentid);
    }

    @Transactional
    public Appointment createAppoiment(AppoimentRequest appoimentRequest)
    {
        Appointment appoimentNew=initAppoiment(appoimentRequest);
        return appoimentRepository.save(appoimentNew);
    }


    private Appointment initAppoiment(AppoimentRequest appoimentRequest){
        Appointment appoimentObj=new Appointment();

        appoimentObj.setMedics(this.medicRepository.findMedicByDni(appoimentRequest.getMedic_dni()));
        appoimentObj.setPatient(this.patientRepository.findPatientByDni(appoimentRequest.getPatient_dni()));
        appoimentObj.setDueDate(appoimentRequest.getDue_date());
        appoimentObj.setStartTime(appoimentRequest.getStart_time());
        appoimentObj.setEndTime(appoimentRequest.getEnd_time());
        appoimentObj.setPaymentMethod(this.paymentMethodRepository.findPaymentMethodById(appoimentRequest.getPayment_id()));
        appoimentObj.setCost(appoimentRequest.getCost());


        return appoimentObj;

    }
}
