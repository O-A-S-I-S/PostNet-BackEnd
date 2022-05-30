package com.api.postnet.entities;


import com.api.postnet.util.BloodType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    @Length(min = 8, message = "Incorrecto DNI")
    @NotBlank(message = "DNI es obligatorio, revise su ingreso")
    private String dni;
    @Column(name = "surname", nullable = false, length = 20)
    @NotBlank(message = "El nombre es obligatorio, revise su ingreso")
    private String surname;
    @Column(name = "last_name", nullable = false, length = 20)
    @NotBlank(message = "Es obligatorio ingresar los apellidos, revise su ingreso")
    private String lastName;
    @Column(name = "email", nullable = false, length = 30, unique = true)
    @NotBlank(message = "Ingrese un email válido")
    private String email;
    @Column(name = "telephone", length = 7)
    private String telephone;
    @Column(name = "cellphone", length = 9)
    private String cellphone;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "password", nullable = false, length = 30)
    @NotBlank(message = "Ingrese su contraseña")
    private String password;
    @Column(name = "blood_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @ManyToMany
    @JoinTable(
            name = "patient_chronic_disease",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "chronic_diseases_id")
    )
    Set<ChronicDisease> chronicDiseases;

    @ManyToMany
    @JoinTable(
            name = "patient_allergy",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_type_id")
    )
    Set<AllergyType> allergyTypes;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    Set<Medic> medics;

}
