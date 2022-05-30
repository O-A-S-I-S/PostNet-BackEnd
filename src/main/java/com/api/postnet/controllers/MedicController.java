package com.api.postnet.controllers;

import com.api.postnet.dto.MedicResponse;
import com.api.postnet.entities.Medic;
import com.api.postnet.services.MedicService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medics")
public class MedicController {
    private MedicService medicService;
    private EntityDtoConverter converter;
    public MedicController(MedicService medicService, EntityDtoConverter converter){
        this.medicService=medicService;
        this.converter=converter;
    }
<<<<<<< HEAD
=======

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

    //URI are stackable
>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
    @GetMapping("/{dni}")
    public ResponseEntity<MedicResponse> findMedicByDni(@PathVariable String dni){
        Medic medic=medicService.getMedicByDni(dni);

        return new ResponseEntity(converter.convertEntityToDto(medic), HttpStatus.OK);
    }
}
