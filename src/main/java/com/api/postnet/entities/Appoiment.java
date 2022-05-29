package com.api.postnet.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="appoiments")
public class Appoiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="due_date")
    private Date dueDate;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name="end_time")
    private Time endTime;
    @Column(name="cost")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name="medic_id",nullable = false)
    private Medic medics;
    @ManyToOne
    @JoinColumn(name = "payment_method_id",nullable = false)
    private Payment_method paymentMethod;
    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

}

