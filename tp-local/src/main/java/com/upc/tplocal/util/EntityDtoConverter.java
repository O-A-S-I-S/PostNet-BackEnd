package com.upc.tplocal.util;

import com.upc.tplocal.dto.LogInResponse;
import com.upc.tplocal.dto.SignUpResponse;
import com.upc.tplocal.entities.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    private ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SignUpResponse convertSignEntityToDto(Person person){
        return modelMapper.map(person, SignUpResponse.class);
    }

    public LogInResponse convertLogEntityToDto(Person person) {
        return modelMapper.map(person,LogInResponse.class);
    }
}
