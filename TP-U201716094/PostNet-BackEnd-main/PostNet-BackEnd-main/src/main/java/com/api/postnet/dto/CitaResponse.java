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
