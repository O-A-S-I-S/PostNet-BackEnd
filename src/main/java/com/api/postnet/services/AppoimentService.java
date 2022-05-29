package com.api.postnet.services;

import com.api.postnet.dto.AppoimentRequest;
import com.api.postnet.entities.Appoiment;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Payment_method;
import com.api.postnet.repository.AppoimentRepository;
import com.api.postnet.repository.MedicRepository;
import com.api.postnet.repository.PatientRepository;
import com.api.postnet.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AppoimentService {
    private AppoimentRepository appoimentRepository;

    private MedicRepository medicRepository;
    private PatientRepository patientRepository;
    private PaymentMethodRepository paymentMethodRepository;
    public AppoimentService(AppoimentRepository appoimentRepository,MedicRepository medicRepository,PatientRepository patientRepository,PaymentMethodRepository paymentMethodRepository){
        this.appoimentRepository=appoimentRepository;
        this.medicRepository=medicRepository;
        this.paymentMethodRepository=paymentMethodRepository;
        this.patientRepository=patientRepository;
    }

    @Transactional
    public Appoiment getAppoimentById(Long appoimentid){
        return appoimentRepository.findAppoimentByAppoimentId(appoimentid);
    }

    @Transactional
    public List<Appoiment> getAppoimentByPatientId(Long patientId){
        return appoimentRepository.findAppointmentByPatientId(patientId);
    }
    @Transactional
    public Appoiment createAppoiment(AppoimentRequest appoimentRequest)
    {
        Appoiment appoimentNew=initAppoiment(appoimentRequest);
        return appoimentRepository.save(appoimentNew);
    }



    private Appoiment initAppoiment(AppoimentRequest appoimentRequest){
        Appoiment appoimentObj=new Appoiment();

        appoimentObj.setMedics(this.medicRepository.findMedicById(appoimentRequest.getMedic_id()));
        appoimentObj.setPatient(this.patientRepository.findPatientById(appoimentRequest.getPatient_id()));
        appoimentObj.setDueDate(new Date());
        appoimentObj.setStartTime(new Time(11,11,11));
        appoimentObj.setEndTime(new Time(11,11,11));
        appoimentObj.setPaymentMethod(this.paymentMethodRepository.findPaymentMethodById(appoimentRequest.getPayment_id()));
        appoimentObj.setCost(100);

        return appoimentObj;

    }
}
