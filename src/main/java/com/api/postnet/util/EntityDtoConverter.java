package com.api.postnet.util;

import com.api.postnet.dto.*;
import com.api.postnet.entities.Appointment;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Speciality;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    //Dependency injection
    private ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
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

}
