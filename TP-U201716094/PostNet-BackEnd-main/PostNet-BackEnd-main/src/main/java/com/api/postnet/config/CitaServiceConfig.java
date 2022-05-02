package com.api.postnet.config;

import com.api.postnet.dto.CitaResponse;
import com.api.postnet.entities.Cita;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CitaServiceConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
