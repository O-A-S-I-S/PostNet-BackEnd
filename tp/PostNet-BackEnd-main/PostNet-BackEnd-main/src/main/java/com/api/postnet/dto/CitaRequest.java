package com.api.postnet.dto;

import com.api.postnet.entities.Doctor;
import com.api.postnet.entities.Paciente;

import java.time.LocalDateTime;
import java.util.Date;
//REQUEST ES LO MINIMO NECESARIO PARA GENERAR LA CITA
public class CitaRequest {
    public LocalDateTime getCitaDate() {
        return citaDate;
    }

    public void setCitaDate(LocalDateTime citaDate) {
        this.citaDate = citaDate;
    }

    private LocalDateTime citaDate;

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
