package com.oasis.postnet.entities;


import com.oasis.postnet.util.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

//notation to auto-generate gets and sets
//creates equals -> used to avoid duplicates in lists
@Data
//entity persistence -> will be created in db
@Entity
//indicate name -> table name must be plural
@Table(name = "medics")
@AllArgsConstructor
@NoArgsConstructor
public class Medic {
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
    @Column(name = "email", nullable = true, length = 20)
    private String email;
    @Column(name = "telephone", nullable = true, length = 7)
    private String telephone;
    @Column(name = "cellphone", nullable = true, length = 9)
    private String cellphone;
    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "password", nullable = true, length = 25)
    private String password;
    @Column(name = "specialty", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Specialty specialty;

}
