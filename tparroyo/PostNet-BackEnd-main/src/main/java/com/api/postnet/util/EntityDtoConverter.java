package com.api.postnet.util;

import com.api.postnet.dto.CitaResponse;
import com.api.postnet.entities.Cita;
import org.modelmapper.ModelMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    private ModelMapper modelMapper;
    EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public CitaResponse convertEntityToDto(Cita cita){
        return modelMapper.map(cita,CitaResponse.class);
    }
    public List<CitaResponse> convertEntityToDto(List<Cita>citas){
        return citas.stream().map(cita->convertEntityToDto(cita)).collect(Collectors.toList());
    }
}
