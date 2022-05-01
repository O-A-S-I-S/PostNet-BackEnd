package com.api.postnet.dto;

import com.api.postnet.entities.Doctor;
import com.api.postnet.entities.Paciente;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.Date;
//REPRESENTA LA RESPUESTA CUANDO QUIERO MOSTRAR EL DETALLE DE LA CITA
public class CitaResponse {
    private String citaId;
    private LocalDateTime dateTime;
    private String status;

    public String getCitaId() {
        return citaId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private Paciente paciente;
    private Doctor doctor;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
