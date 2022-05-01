package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;
import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String citaId;
    @Column(name="paciente_Id",nullable = false)
    private String pacienteId;
    @Column(name="doctor_Id",nullable = false)
    private String doctorId;
    @Column(name="status")
    private String status;
    @Column(name="fecha")
    private LocalDateTime dateTime;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCitaId() {
        return citaId;
    }

    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


}
