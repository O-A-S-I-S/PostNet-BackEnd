package com.api.postnet.util;


import com.api.postnet.dto.AppoimentResponse;
import com.api.postnet.dto.MedicResponse;
import com.api.postnet.dto.PatientResponse;
import com.api.postnet.entities.Appoiment;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Payment_method;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.entities.Prescription;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {
    private ModelMapper modelMapper;

    EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public AppoimentResponse convertEntityToDto(Appoiment appoiment){
        return modelMapper.map(appoiment,AppoimentResponse.class);
    }
    public List<AppoimentResponse> convertEntityToDto(List<Appoiment>appoiments){
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
}

    public PrescriptionResponse convertEntityToDto(Prescription prescription){
        return modelMapper.map(prescription,PrescriptionResponse.class);
    }


}
