package com.api.postnet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class SpecialtyServiceConfig {
    @Bean
    public ModelMapper modelMapperSpeciality(){return new ModelMapper();}
}
