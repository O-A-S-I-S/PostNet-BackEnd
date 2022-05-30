package com.api.postnet.controllers;

import com.api.postnet.dto.ScheduleResponse;
import com.api.postnet.entities.Appoiment;
import com.api.postnet.services.DoctorService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorService;
    private EntityDtoConverter converter;

    public DoctorController(DoctorService doctorService, EntityDtoConverter converter){
        this.doctorService = doctorService;
        this.converter = converter;
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<List<ScheduleResponse>> findScheduleByDoctorId(@PathVariable Long doctorId){
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Appoiment> appoiments = doctorService.getAllAppoimentsById(doctorId, convertToDateViaSqlTimestamp(localDateTime));
        return new ResponseEntity(converter.convertAppoimentToDto(appoiments), HttpStatus.OK);
    }

    public Date convertToDateViaSqlTimestamp(LocalDateTime  dateToConverter){
        return java.sql.Timestamp.valueOf(dateToConverter);
    }
}
