package com.api.postnet.controllers;


import com.api.postnet.dto.CitaRequest;
import com.api.postnet.dto.CitaResponse;
import com.api.postnet.entities.Cita;
import com.api.postnet.entities.Doctor;
import com.api.postnet.entities.Paciente;
import com.api.postnet.services.CitaService;
import com.api.postnet.util.EntityDtoConverter;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;
@RestController
@RequestMapping("api/v1/citas")
public class CitaController {

    private CitaService citaService;

    private EntityDtoConverter converter;

    public CitaController(CitaService citaService,EntityDtoConverter converter){
        this.citaService=citaService;
        this.converter=converter;
    }



    @GetMapping
    public ResponseEntity<List<CitaResponse>>findAllCitas(){
        List<CitaResponse>citas=new ArrayList<>();
        CitaResponse response_01=new CitaResponse();
        response_01.setCitaId("123");
        response_01.setDateTime(LocalDateTime.of(2022,3,30,12,0));
        response_01.setStatus("PENDIENTE");
        Doctor medico=new Doctor();
        medico.setDoctorId("1");
        medico.setDoctorName("Josue");
        Paciente paciente=new Paciente();
        paciente.setPacienteId("7714");
        paciente.setPacienteName("Luis");
        response_01.setDoctor(medico);
        response_01.setPaciente(paciente);
        citas.add(response_01);

        CitaResponse response_02=new CitaResponse();
        response_02.setCitaId("124");
        response_02.setDateTime(LocalDateTime.of(2022,3,30,12,0));
        response_02.setStatus("PENDIENTE");
        Doctor medico2=new Doctor();
        medico2.setDoctorId("2");
        medico2.setDoctorName("Joaquin");
        Paciente paciente2=new Paciente();
        paciente2.setPacienteId("7715");
        paciente2.setPacienteName("Marcos");
        response_02.setDoctor(medico2);
        response_02.setPaciente(paciente2);
        citas.add(response_02);
        return new ResponseEntity(citas, HttpStatus.OK);
    }

    @GetMapping("/{citaId}")
    public ResponseEntity<CitaResponse>findCitaPerId(@PathVariable String citaId){
        CitaResponse response_01=new CitaResponse();
        response_01.setCitaId(citaId);
        response_01.setDateTime(LocalDateTime.of(2022,3,30,12,0));
        response_01.setStatus("PENDIENTE");
        Doctor medico=new Doctor();
        medico.setDoctorId("1");
        medico.setDoctorName("Josue");
        Paciente paciente=new Paciente();
        paciente.setPacienteId("7714");
        paciente.setPacienteName("Luis");
        response_01.setDoctor(medico);
        response_01.setPaciente(paciente);

        return new ResponseEntity(response_01,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CitaResponse> createCita(@RequestBody CitaRequest request){
//        CitaResponse response_01=new CitaResponse();
//        response_01.setCitaId(request.getCitaId());
//        response_01.setCitaDate(request.getCitaDate());
//        response_01.setStatus("PENDIENTE");
//        Doctor medico=new Doctor();
//        medico.setDoctorId(request.getDoctor().getDoctorId());
//        medico.setDoctorName(request.getDoctor().getDoctorName());
//        Paciente paciente=new Paciente();
//        paciente.setPacienteId(request.getPaciente().getPacienteId());
//        paciente.setPacienteName(request.getPaciente().getPacienteName());
//        response_01.setDoctor(medico);
//        response_01.setPaciente(paciente);
        //return new ResponseEntity(response_01,HttpStatus.OK);
        Cita cita   =citaService.createCita(request);

        return new ResponseEntity(converter.convertEntityToDto(cita),HttpStatus.CREATED);
    }

}
