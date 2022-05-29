package com.oasis.postnet.controllers;

import com.oasis.postnet.dto.LogInRequest;
import com.oasis.postnet.dto.LogInResponse;
import com.oasis.postnet.dto.MedicRequest;
import com.oasis.postnet.dto.MedicResponse;
import com.oasis.postnet.entities.Medic;
import com.oasis.postnet.services.MedicService;
import com.oasis.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Spring notation to read HTTP verbs
@RestController
// URI -> set
@RequestMapping("/medics")
public class MedicController {

    private MedicService medicService;
    private EntityDtoConverter converter;

    public MedicController(MedicService medicService, EntityDtoConverter converter){
        this.medicService = medicService;
        this.converter = converter;
    }

    //When reading Get verb -> execute
    @GetMapping
    //ResponseEntity -> transformation from Java list to JSON and include HTTPStatus
    public ResponseEntity<List<MedicResponse>> getAllMedics(){
        List<MedicResponse> medics = converter.convertMedicToDto(medicService.getAllMedics());

        return new ResponseEntity<>(medics, HttpStatus.OK);
    }

    @GetMapping("/specialty/{specialty}")
    public ResponseEntity<List<MedicResponse>> findMedicsBySpecialty(@PathVariable String specialty){

        return new ResponseEntity<>(converter.convertMedicToDto(medicService.getMedicsBySpecialty(specialty)), HttpStatus.OK);
    }

}
