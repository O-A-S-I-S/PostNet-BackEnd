package com.api.postnet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicResponse {

    private String dni;
    private String surName;
    private String lastName;
    private String telephone;
    private String cellphone;
    private String email;
    private Date birthDate;

    private SpecialityResponse specialty;

}
