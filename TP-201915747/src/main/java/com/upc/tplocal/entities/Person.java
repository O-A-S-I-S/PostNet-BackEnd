package com.upc.tplocal.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "persons")

public class Person {
    @Id
    private String person_id;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "email")
    private String email;
    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth_date;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "password", nullable = false)
    private String password;
}
