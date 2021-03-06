package com.api.postnet.controllers;

import com.api.postnet.dto.*;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Prescription;
import com.api.postnet.services.MedicService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Spring notation to read HTTP verbs
@RestController
// URI -> set
@RequestMapping("/medics")
//@CrossOrigin(origins = "http://localhost:4200/")
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

    @GetMapping("/speciality/{speciality}")
    public ResponseEntity<List<MedicResponse>> findMedicsByspeciality(@PathVariable String speciality){

        return new ResponseEntity<>(converter.convertMedicToDto(medicService.getMedicsByspeciality(speciality)), HttpStatus.OK);
    }

    //URI are stackable
    @GetMapping("/{dni}")
    //ResponseEntity -> conversion to JSON and HttpStatus
    //PathVariable captures the input URI and stores it in a variable
    public ResponseEntity<MedicResponse> findMedicById(@PathVariable String dni){

        Medic medic = medicService.getMedicByDni(dni);

        return new ResponseEntity(converter.convertMedicToDto(medic), HttpStatus.OK);
    }

    @GetMapping("/log_in")
    public ResponseEntity<LogInResponse> getMedicByDniAndPassword(@RequestBody LogInRequest logInRequest){
        return new ResponseEntity(converter.convertMedicLogInToDto(medicService.findMedicByDniAndPassword(logInRequest.getDni(), logInRequest.getPassword())), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createMedic(@Valid @RequestBody MedicRequest medicRequest){

        return new ResponseEntity(converter.convertMedicToDto(medicService.createMedic(medicRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/find/{dni}")
    public ResponseEntity<List<PrescriptionResponse>> findPrescriptionByPatient(@PathVariable String dni){
        List<Prescription>prescriptions=medicService.findPatientPrescriptions(dni);
        return new ResponseEntity(converter.convertPrescriptionToDto(prescriptions),HttpStatus.OK);

    }
}
