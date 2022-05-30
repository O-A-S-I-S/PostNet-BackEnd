package com.api.postnet.dto;

<<<<<<< HEAD
=======
import com.api.postnet.util.BloodType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
public class PatientRequest {
<<<<<<< HEAD
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
=======
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
    private LocalDate birthDate;
    @NotBlank(message = "Ingrese su contraseña")
    private String password;
<<<<<<< HEAD
    @NotBlank(message = "Tipos de sangre válidos: Oplus,Ominus,Aplus,Aminus,Bplus,Bminus,ABplus,ABminus")
    private String bloodType;
>>>>>>> parent of 7dce8b6 (added .json with postman patients operations)
=======
    private BloodType bloodType;
>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
}
