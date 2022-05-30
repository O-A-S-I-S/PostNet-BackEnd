package com.api.postnet.dto;

import com.api.postnet.util.BloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    @NotBlank
    private String dni;
    @NotBlank
    private String surName;
    @NotBlank
    private String lastName;
    private String telephone;
    private String cellphone;
    @NotBlank
    private String email;
    @NotBlank
    private Date birthDate;
    @NotBlank
    private String password;
    private BloodType bloodType;
}
