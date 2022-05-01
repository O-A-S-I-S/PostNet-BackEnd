package com.api.postnet.services;

import com.api.postnet.dto.CitaRequest;
import com.api.postnet.dto.CitaResponse;
import com.api.postnet.entities.Cita;
import com.api.postnet.entities.Doctor;
import com.api.postnet.entities.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CitaService {
    public Cita createCita(CitaRequest citaRequest)
    {
//        Cita response=new Cita();
//        response.setCitaId("123");
//        response.setDateTime(LocalDateTime.of(2022,3,30,12,0));
//        response.setStatus("PENDIENTE");
//        Doctor medico=new Doctor();
//        medico.setDoctorId("1");
//        medico.setDoctorName("Josue");
//        Paciente paciente=new Paciente();
//        paciente.setPacienteId("7714");
//        paciente.setPacienteName("Luis");
//        response.setDoctor(medico);
//        response.setPaciente(paciente);
        Cita response=new Cita();
        response.setCitaId("123");


//        response.setDateTime(citaRequest.getCitaDate());
        response.setDateTime(citaRequest.getCitaDate());

        response.setStatus("PENDIENTE");
//        Doctor medico=citaRequest.getDoctor();
//        medico.setDoctorId(citaRequest);
//        medico.setDoctorName("Josue");
//        Paciente paciente=citaRequest.getPaciente();
//        paciente.setPacienteId("7714");
//        paciente.setPacienteName("Luis");
        response.setDoctorId(citaRequest.getDoctor().getDoctorId());
        response.setPacienteId(citaRequest.getPaciente().getPacienteId());
        return response;
    }
}
