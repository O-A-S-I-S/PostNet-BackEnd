package com.api.postnet.util;


import com.api.postnet.dto.*;
import com.api.postnet.entities.Appointment;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Payment_method;
import com.api.postnet.repository.MedicineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.api.postnet.entities.Prescription;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {
    private ModelMapper modelMapper;
    private MedicineRepository medicineRepository;

    EntityDtoConverter(ModelMapper modelMapper,MedicineRepository medicineRepository){
        this.modelMapper=modelMapper;
        this.medicineRepository=medicineRepository;
    }

    public AppoimentResponse convertEntityToDto(Appointment appoiment){
        return modelMapper.map(appoiment,AppoimentResponse.class);
    }
    public List<AppoimentResponse> convertEntityToDto(List<Appointment>appoiments){
        return appoiments.stream().map(appoiment->convertEntityToDto(appoiment)).collect(Collectors.toList());
    }

    public MedicResponse convertEntityToDto(Medic medic){
        return  modelMapper.map(medic,MedicResponse.class);
    }
    public PatientResponse convertEntityToDto(Patient patient){
        return  modelMapper.map(patient,PatientResponse.class);
    }
    public Payment_method convertEntityToDto(Payment_method payment_method){
        return  modelMapper.map(payment_method,Payment_method.class);

    }
    public PrescriptionResponse convertEntityToDto(Prescription prescription){
        return modelMapper.map(prescription,PrescriptionResponse.class);
    }
    public PrescriptionResponse convertPrescriptionToDto(Prescription prescription){
        PrescriptionResponse temp = new PrescriptionResponse();
        temp.setId(prescription.getId());
        temp.setDescription(prescription.getDescription());
        List<PrescriptionMedicinesResponse> temp2 = medicineRepository.getAllByPrescriptionAndId(prescription.getId())
                .stream().map(medicine -> PrescriptionMedicinesResponse.builder()
                        .nameMedicine(medicine.getName()).build()
                ).collect(Collectors.toList());
        temp.setPrescriptionMedicines(temp2);
        return temp;
        //return modelMapper.map(prescription, PrescriptionResponse.class);
    }
    public List<PrescriptionResponse> convertPrescriptionToDto(List<Prescription> prescriptions){
        return prescriptions.stream()
                .map(prescription -> convertPrescriptionToDto(prescription))
                .collect(Collectors.toList());
    }


}

