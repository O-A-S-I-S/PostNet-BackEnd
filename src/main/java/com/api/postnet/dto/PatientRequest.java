package com.api.postnet.dto;

import com.api.postnet.util.BloodType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    @NotBlank(message = "DNI es obligatorio, revise su ingreso")
    private String dni;
    @NotBlank(message = "El nombre es obligatorio, revise su ingreso")
    private String surName;
    @NotBlank(message = "Es obligatorio ingresar los apellidos, revise su ingreso")
    private String lastName;
    @NotBlank(message = "Ingrese un email válido")
    private String email;
    private String telephone;
    private String cellphone;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthDate;
    @NotBlank(message = "Ingrese su contraseña")
    private String password;
    private BloodType bloodType;
}
