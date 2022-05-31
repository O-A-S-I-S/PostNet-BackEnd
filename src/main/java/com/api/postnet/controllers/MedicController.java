package com.api.postnet.controllers;

import com.api.postnet.dto.MedicResponse;
import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Prescription;
import com.api.postnet.services.MedicService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medics")
public class MedicController {
    private MedicService medicService;
    private EntityDtoConverter converter;
    public MedicController(MedicService medicService, EntityDtoConverter converter){
        this.medicService=medicService;
        this.converter=converter;
    }
    @GetMapping("/{dni}")
    public ResponseEntity<MedicResponse> findMedicByDni(@PathVariable String dni){
        Medic medic=medicService.getMedicByDni(dni);

        return new ResponseEntity(converter.convertEntityToDto(medic), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PrescriptionResponse>> findPrescriptionByPatient(@RequestParam(value="patientId") Long patientId){
        List<Prescription>prescriptions=medicService.findPatientPrescriptions(patientId);
        return new ResponseEntity(converter.convertPrescriptionToDto(prescriptions),HttpStatus.OK);

    }
}
