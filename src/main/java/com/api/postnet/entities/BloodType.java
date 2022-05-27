package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "blood_types")
@Data
public class BloodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "blood_type", nullable = false, length = 3)
    private String bloodType;
}
