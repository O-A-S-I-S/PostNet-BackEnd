package com.api.postnet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientServiceConfig {
    @Bean
    public ModelMapper modelMapperPatient(){return new ModelMapper();}
}
