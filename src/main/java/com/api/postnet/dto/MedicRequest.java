package com.api.postnet.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicRequest {
    @NotBlank
    private String dni;
    @NotBlank
    private String surName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    private String telephone;
    private String cellphone;
    private Date birthDate;
    @NotBlank
    private String password;
    private String specialty;
}
