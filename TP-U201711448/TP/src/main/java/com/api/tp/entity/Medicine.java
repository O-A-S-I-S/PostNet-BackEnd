package com.api.tp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "medicina")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nombre")
    private String name;
    @Column(name="descripccion")
    private String description;
    @ManyToMany
    private List<Prescription>prescriptions;
}
