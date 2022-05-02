package com.api.postnet.services;

import com.api.postnet.dto.CitaRequest;
import com.api.postnet.entities.Cita;
import com.api.postnet.repository.CitaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CitaService {
    private CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository){
        this.citaRepository=citaRepository;
    }

    @Transactional
    public Cita getCitaById(String citaId){
      return citaRepository.findCitaByCitaId(citaId);
    }

    @Transactional
    public List<Cita> getCitaByPacienteId(String pacienteId){
        return citaRepository.findCitaByPacienteId(pacienteId);
    }
    @Transactional
    public Cita createCita(CitaRequest citaRequest)
    {
        Cita citaNew=initCita(citaRequest);
        return citaRepository.save(citaNew);
    }

    private Cita initCita(CitaRequest citaRequest){
        Cita citaObj=new Cita();

        citaObj.setCitaId(UUID.randomUUID().toString());
        citaObj.setPacienteId(citaRequest.getPacienteId());
        citaObj.setDoctorId(citaRequest.getDoctorId());
        citaObj.setStatus("PENDIENTE");
        citaObj.setDateTime(LocalDateTime.of(2020,01,20,10,03));

        return citaObj;

    }
}
