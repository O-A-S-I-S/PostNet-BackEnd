package com.api.postnet.util;

import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.entities.Prescription;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    private ModelMapper modelMapper;
    public EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public PrescriptionResponse convertEntityToDto(Prescription prescription){
        return modelMapper.map(prescription,PrescriptionResponse.class);
    }


}