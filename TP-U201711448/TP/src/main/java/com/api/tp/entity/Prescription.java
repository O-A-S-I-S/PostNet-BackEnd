package com.api.tp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name="prescripcion")
@PrimaryKeyJoinColumn(name="appointment_id")
public class Prescription extends Appointment {

    @Column(name = "descripcion")
    private String description;
}
