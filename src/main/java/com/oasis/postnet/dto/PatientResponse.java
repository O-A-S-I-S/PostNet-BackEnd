package com.oasis.postnet.dto;

import com.oasis.postnet.util.BloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private Long id;
    private String dni;
    private String surName;
    private String lastName;
    private String telephone;
    private String cellphone;
    private String email;
    private Date birthDate;
    private String password;
    private BloodType bloodType;

}
