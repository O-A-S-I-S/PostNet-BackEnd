package com.oasis.postnet.entities;

import com.oasis.postnet.util.BloodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Column(name = "surname", nullable = false, length = 20)
    private String surName;
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;
    @Column(name = "telephone", nullable = true, length = 7)
    private String telephone;
    @Column(name = "cellphone", nullable = true, length = 9)
    private String cellphone;
    @Column(name = "email", nullable = true, length = 20)
    private String email;
    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "password", nullable = true, length = 25)
    private String password;
    @Column(name = "blood_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BloodType bloodType;

}
