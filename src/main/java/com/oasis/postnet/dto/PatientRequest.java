package com.oasis.postnet.dto;

import com.oasis.postnet.util.BloodType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
