package com.api.postnet.entities;


import com.api.postnet.util.BloodType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;
    @Column(name = "surname", nullable = false, length = 20)
    private String surname;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String email;
    @Column(name = "telephone", length = 7)
    private String telephone;
    @Column(name = "cellphone", length = 9)
    private String cellphone;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "password", nullable = false, length = 30)
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
