package com.oasis.postnet.entities;

import com.oasis.postnet.util.BloodType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "person_id")
public class Patient extends Person {
    @Column(name = "blood_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BloodType bloodType;

}
