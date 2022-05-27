package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "allergens")
@Data
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String allergen;
}
