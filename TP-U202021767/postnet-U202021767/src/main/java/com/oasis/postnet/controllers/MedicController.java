package com.oasis.postnet.controllers;

import com.oasis.postnet.dto.MedicResponse;
import com.oasis.postnet.entities.Medic;
import com.oasis.postnet.services.MedicService;
import com.oasis.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //URI are stackable
    @GetMapping("/{dni}")
    //ResponseEntity -> conversion to JSON and HttpStatus
    //PathVariable captures the input URI and stores it in a variable
    public ResponseEntity<MedicResponse> findMedicById(@PathVariable String dni){

        Medic medic = medicService.getMedicByDni(dni);

        return new ResponseEntity(converter.convertMedicToDto(medic), HttpStatus.OK);
    }

}
