package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "allergy_types")
@Data
public class AllergyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allergy_type_id")
    private Long id;
    @Column(nullable = false, length = 30)
    private String terminology;

    @ManyToOne
    @JoinColumn(name = "allergen_id")
    private Allergen allergen;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "allergyTypes")
    Set<Patient> patients;
}
