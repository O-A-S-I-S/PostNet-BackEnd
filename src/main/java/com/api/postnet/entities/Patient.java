package com.api.postnet.entities;


import com.api.postnet.util.BloodType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Column(name = "surname", nullable = false, length = 20)
    private String surname;
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;
    @Column(name = "email", nullable = false, length = 30)
    private String email;
    @Column(name = "telephone", nullable = false, length = 7)
    private String telephone;
    @Column(name = "cellphone", nullable = false, length = 9)
    private String cellphone;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "password", nullable = false, length = 30)
    private String password;
    @Column(name = "blood_type", nullable = false)
    private BloodType bloodType;

    @ManyToMany
    @JoinTable(
            name = "patient_chronic_disease",
            joinColumns = @JoinColumn(name = "patients_id"),
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

    @ManyToMany(mappedBy = "patients")
    Set<Medic> medics;

}
