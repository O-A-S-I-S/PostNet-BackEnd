package com.upc.tplocal.services;

import com.upc.tplocal.dto.LogInRequest;
import com.upc.tplocal.dto.SignUpRequest;
import com.upc.tplocal.entities.Person;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class SignUpService {

    public Person createPerson(SignUpRequest signUpRequest){
        return initPerson(signUpRequest);
    }

    private Person initPerson(SignUpRequest signUpRequest) {
        Person person = new Person();

        person.setPerson_id(signUpRequest.getPerson_id());
        person.setTelephone(signUpRequest.getTelephone());
        person.setCellphone(signUpRequest.getCellphone());
        person.setEmail(signUpRequest.getEmail());
        person.setBirth_date(signUpRequest.getBirth_date());
        person.setSurname(signUpRequest.getSurname());
        person.setLastname(signUpRequest.getLastname());
        person.setPassword(signUpRequest.getPassword());

        return person;
    }

    public Person fetchPerson(LogInRequest logInRequest){
        Person person =  new Person();

        //test
        person.setPerson_id(logInRequest.getPerson_id());
        person.setTelephone("012519647");
        person.setCellphone("956230225");
        person.setEmail("luis.alonso97@outlook.com");
        person.setBirth_date(Timestamp.valueOf(LocalDateTime.now()));
        person.setSurname("Luis");
        person.setLastname("Pineda");
        return person;
    }

}
