package com.api.postnet.dto;

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
>>>>>>> parent of 7dce8b6 (added .json with postman patients operations)
}
