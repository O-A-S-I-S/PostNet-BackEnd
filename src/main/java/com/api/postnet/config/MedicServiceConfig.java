package com.api.postnet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicServiceConfig {
    @Bean
    public ModelMapper modelMapperMedic(){return new ModelMapper();}
}
