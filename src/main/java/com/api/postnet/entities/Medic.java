package com.api.postnet.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="medics")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="dni",nullable = false,length = 8)
    private String dni;
    @Column(name="surname",nullable = false,length = 20)
    private String surname;
    @Column(name ="last_name",nullable = false,length = 20)
    private String lastName;
    @Column(name ="email",nullable = false,length = 30)
    private String email;
    @Column(name ="telephone",nullable = false,length = 7)
    private String telephone;
    @Column(name ="cellphone",nullable = false,length = 9)
    private String cellphone;
    @Column(name ="birth_date",nullable = false)
    private Date birthDate;
    @Column(name ="password",nullable = false,length = 30)
    private String password;

    @OneToOne
    @JoinColumn(name="speciality_id",nullable = false)
    private Speciality speciality;

    @ManyToMany
    @JoinTable(
            name = "medic_patient_preference",
            joinColumns = @JoinColumn(name = "medic_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    Set<Patient> patients;

}
