package com.api.postnet.controllers;

import com.api.postnet.dto.AppointmentRequest;
import com.api.postnet.dto.AppointmentResponse;
import com.api.postnet.entities.Appointment;
import com.api.postnet.services.AppointmentService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class AppointmentController {
    private AppointmentService appoimentService;
    private EntityDtoConverter converter;
    public AppointmentController(AppointmentService appoimentService, EntityDtoConverter converter){
        this.appoimentService=appoimentService;
        this.converter=converter;
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> findAppointmentById(@PathVariable Long id){
        Appointment appointment=appoimentService.getAppointmentById(id);

        return new ResponseEntity(converter.convertEntityToDto(appointment), HttpStatus.OK);
    }
    @GetMapping("/patients/{patientDni}")
    public ResponseEntity<AppointmentResponse>findAppointmentByPatientDni(@PathVariable String patientDni){
        List<Appointment> appointments=appoimentService.getAppointmentByPatientDni(patientDni);

        return new ResponseEntity(converter.convertEntityToDto(appointments),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAppointmentById(@PathVariable Long id){
        appoimentService.deleteAppointment(id);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppoiment(@RequestBody AppointmentRequest request){
        Appointment appointment=appoimentService.createAppointment(request);
        return new ResponseEntity<>(converter.convertEntityToDto(appointment),HttpStatus.CREATED);
    }

}