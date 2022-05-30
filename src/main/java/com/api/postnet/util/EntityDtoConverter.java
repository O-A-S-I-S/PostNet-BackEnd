package com.api.postnet.util;


import com.api.postnet.dto.AppoimentResponse;
import com.api.postnet.entities.Appointment;
import com.api.postnet.entities.Payment_method;
import org.springframework.stereotype.Service;
import com.api.postnet.dto.PrescriptionResponse;
import com.api.postnet.entities.Prescription;

import com.api.postnet.dto.LogInResponse;
import com.api.postnet.dto.MedicResponse;
import com.api.postnet.dto.PatientResponse;
import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    private ModelMapper modelMapper;

    EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public AppoimentResponse convertEntityToDto(Appointment appoiment){
        return modelMapper.map(appoiment,AppoimentResponse.class);
    }
    public List<AppoimentResponse> convertEntityToDto(List<Appointment>appoiments){
        return appoiments.stream().map(appoiment->convertEntityToDto(appoiment)).collect(Collectors.toList());
    }


    public Payment_method convertEntityToDto(Payment_method payment_method){
        return  modelMapper.map(payment_method,Payment_method.class);

    }
    public PrescriptionResponse convertEntityToDto(Prescription prescription){
        return modelMapper.map(prescription,PrescriptionResponse.class);
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

