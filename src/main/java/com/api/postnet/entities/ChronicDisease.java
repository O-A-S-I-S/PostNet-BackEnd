package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chronic_diseases")
@Data
public class ChronicDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false ,length = 20)
    private String name;
    @Column(length = 80)
    private String description;

    @ManyToMany(mappedBy = "chronicDiseases")
    Set<Patient> patients;
}
