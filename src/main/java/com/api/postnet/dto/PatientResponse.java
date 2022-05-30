package com.api.postnet.dto;


import com.api.postnet.util.BloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate birthDate;
    private String password;
    private BloodType bloodType;

}
