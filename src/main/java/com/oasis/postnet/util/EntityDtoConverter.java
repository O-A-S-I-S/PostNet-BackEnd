package com.oasis.postnet.util;

import com.oasis.postnet.dto.LogInResponse;
import com.oasis.postnet.dto.MedicResponse;
import com.oasis.postnet.dto.PatientResponse;
import com.oasis.postnet.entities.Medic;
import com.oasis.postnet.entities.Patient;
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

}
