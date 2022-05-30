package com.api.postnet.util;

import com.api.postnet.dto.PrescriptionMedicinesResponse;
import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.dto.ScheduleResponse;
import com.api.postnet.entities.Appoiment;
import com.api.postnet.entities.Medicine;
import com.api.postnet.entities.Prescription;
import com.api.postnet.repository.MedicineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {
    private ModelMapper modelMapper;
    private MedicineRepository medicineRepository;
    public EntityDtoConverter(ModelMapper modelMapper, MedicineRepository medicineRepository){
        this.modelMapper = modelMapper;
        this.medicineRepository = medicineRepository;
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }
    public ScheduleResponse convertAppoimentToDto(Appoiment appoiment){
        return modelMapper.map(appoiment, ScheduleResponse.class);
    }
    public List<ScheduleResponse> convertAppoimentToDto(List<Appoiment> appoiments){
        return appoiments.stream()
                .map(appoiment -> convertAppoimentToDto(appoiment))
                .collect(Collectors.toList());
    }
    public PrescriptionResponse convertPrescriptionToDto(Prescription prescription){
        PrescriptionResponse temp = new PrescriptionResponse();
        temp.setPrescriptionId(prescription.getId());
        temp.setPrescriptionDescription(prescription.getDescription());
        List<PrescriptionMedicinesResponse> temp2 = medicineRepository.getAllByPrescriptionAndId(prescription.getId())
                .stream().map(medicine -> PrescriptionMedicinesResponse.builder()
                        .nameMedicine(medicine.getName()).build()
                ).collect(Collectors.toList());
        temp.setPrescriptionMedicinesResponses(temp2);
        return temp;
        //return modelMapper.map(prescription, PrescriptionResponse.class);
    }
    public List<PrescriptionResponse> convertPrescriptionToDto(List<Prescription> prescriptions){
        return prescriptions.stream()
                .map(prescription -> convertPrescriptionToDto(prescription))
                .collect(Collectors.toList());
    }
}
