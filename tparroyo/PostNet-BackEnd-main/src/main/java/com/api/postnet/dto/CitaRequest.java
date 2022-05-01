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

    private String pacienteId;
    private String doctorId;

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
