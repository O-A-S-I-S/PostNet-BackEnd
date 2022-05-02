package com.oasis.postnet.dto;

import com.oasis.postnet.entities.Person;
import com.oasis.postnet.util.BloodType;

public class PatientRequest {
    private String dni;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
