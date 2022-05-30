package com.api.postnet.dto;

public class MedicRequest {
<<<<<<< HEAD
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
=======
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
    private String password;
    @NotBlank
    private String specialty;
>>>>>>> parent of 3c81fa9 (fixed errors with patient sign in and blood type)
}
