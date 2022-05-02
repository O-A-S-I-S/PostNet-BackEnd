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
@RequestMapping("/citas")
public class CitaController {

    private CitaService citaService;
    private EntityDtoConverter converter;
    public CitaController(CitaService citaService,EntityDtoConverter converter){
        this.citaService=citaService;
        this.converter=converter;
    }


    @GetMapping("/{citaId}")
    public ResponseEntity<CitaResponse>findCitaById(@PathVariable String citaId){
        Cita cita=citaService.getCitaById(citaId);

        return new ResponseEntity(converter.convertEntityToDto(cita),HttpStatus.OK);
    }
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<CitaResponse>findCitaByPacienteId(@PathVariable String pacienteId){
        List<Cita>citas=citaService.getCitaByPacienteId(pacienteId);

        return new ResponseEntity(converter.convertEntityToDto(citas),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CitaResponse> createCita(@RequestBody CitaRequest request){
        Cita cita=citaService.createCita(request);
        return new ResponseEntity<>(converter.convertEntityToDto(cita),HttpStatus.CREATED);
    }

}
