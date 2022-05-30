package com.api.postnet.entities;

import com.api.postnet.util.PaymentMethod;
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
@Table(name="appointments")
public class Appointment {
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
    @Column(name = "payment_method")
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name="medic_id",nullable = false)
    private Medic medics;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "prescription_id", referencedColumnName = "id")
    private Prescription prescription;

}

