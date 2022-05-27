package com.api.postnet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="Prescription")
@PrimaryKeyJoinColumn(name="id")
public class Prescription extends Appoiment {
    @Column(name="description",nullable = false,length = 100)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "prescription_medicine",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id")
    )
    Set<Medicine> medicines;

}
