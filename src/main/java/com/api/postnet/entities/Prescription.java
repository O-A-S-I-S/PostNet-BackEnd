package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="prescriptions")
public class Prescription{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private Appointment appointment;

    @ManyToMany
    @JoinTable(
            name = "prescription_medicine",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id")
    )
    Set<Medicine> medicines;

    @Column(nullable = false, length = 100)
    private String description;
}
