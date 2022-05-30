package com.api.postnet.dto;

import com.api.postnet.util.BloodType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    @NotBlank(message = "DNI es obligatorio, revise su ingreso")
    @Length(min = 8, message = "Incorrecto DNI")
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
    private LocalDate birthDate;
    @NotBlank(message = "Ingrese su contraseña")
    private String password;
    @NotBlank(message = "Tipos de sangre válidos: Oplus,Ominus,Aplus,Aminus,Bplus,Bminus,ABplus,ABminus")
    private String bloodType;
}
