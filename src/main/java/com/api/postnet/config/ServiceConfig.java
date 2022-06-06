package com.api.postnet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuration class in Sprint Framework
@Configuration
public class ServiceConfig {
    //life cycle is administered by the same container
    //create instance -> include in specified class -> ready for use -> delete when not in use
    @Bean
    public ModelMapper modelMapperPerson(){
        return new ModelMapper();
    }
}
