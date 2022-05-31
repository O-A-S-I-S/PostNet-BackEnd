package com.api.postnet.dto;

import com.api.postnet.util.BloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {

    private String dni;
    private String surName;
    private String lastName;
    private String telephone;
    private String cellphone;
    private String email;
    private Date birthDate;

    private BloodType bloodType;

}
