package com.api.postnet.util;

import com.api.postnet.dto.*;
import com.api.postnet.entities.*;
import com.api.postnet.repository.MedicineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    //Dependency injection
    private ModelMapper modelMapper;
    private MedicineRepository medicineRepository;

    public EntityDtoConverter(ModelMapper modelMapper, MedicineRepository medicineRepository){
        this.modelMapper = modelMapper;
        this.medicineRepository = medicineRepository;
    }

    public MedicResponse convertMedicToDto(Medic medic){
        return modelMapper.map(medic, MedicResponse.class);
    }

    public List<MedicResponse> convertMedicToDto(List<Medic> medics){
        return medics.stream()
                .map(medic->convertMedicToDto(medic))
                .collect(Collectors.toList());
    }

    public PatientResponse convertPatientToDto(Patient patient){
        return modelMapper.map(patient, PatientResponse.class);
    }

    public List<PatientResponse> convertPatientToDto(List<Patient> patients){
        return patients.stream()
                .map(patient->convertPatientToDto(patient))
                .collect(Collectors.toList());
    }

    public LogInResponse convertMedicLogInToDto(Medic medic){
        return modelMapper.map(medic, LogInResponse.class);
    }

    public LogInResponse convertPatientToLogInDto(Patient patient){
        return modelMapper.map(patient, LogInResponse.class);
    }
    public AppointmentResponse convertEntityToDto(Appointment appointment){
        return modelMapper.map(appointment, AppointmentResponse.class);
    }
    public SpecialityResponse convertEntityToDto(Speciality speciality){
        return modelMapper.map(speciality, SpecialityResponse.class);
    }
    public List<AppointmentResponse> convertEntityToDto(List<Appointment>appointments){
        return appointments.stream().map(appointment->convertEntityToDto(appointment)).collect(Collectors.toList());
    }

    public MedicResponse convertEntityToDto(Medic medic){
        return  modelMapper.map(medic,MedicResponse.class);
    }
    public PatientResponse convertEntityToDto(Patient patient){
        return  modelMapper.map(patient,PatientResponse.class);
    }

    public PrescriptionResponse convertEntityToDto(Prescription prescription){
        return modelMapper.map(prescription,PrescriptionResponse.class);
    }
    public PrescriptionResponse convertPrescriptionToDto(Prescription prescription){
        PrescriptionResponse temp = new PrescriptionResponse();
        temp.setId(prescription.getId());
        temp.setDescription(prescription.getDescription());
        List<PrescriptionMedicinesResponse> temp2 = medicineRepository.getAllByPrescriptionAndId(prescription.getId())
                .stream().map(medicine -> PrescriptionMedicinesResponse.builder()
                        .nameMedicine(medicine.getName()).build()
                ).collect(Collectors.toList());
        temp.setPrescriptionMedicines(temp2);
        return temp;
        //return modelMapper.map(prescription, PrescriptionResponse.class);
    }
    public List<PrescriptionResponse> convertPrescriptionToDto(List<Prescription> prescriptions){
        return prescriptions.stream()
                .map(prescription -> convertPrescriptionToDto(prescription))
                .collect(Collectors.toList());
    }

}
