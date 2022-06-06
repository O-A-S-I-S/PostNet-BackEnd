package com.api.postnet.dto;

import com.api.postnet.entities.Prescription;
import com.api.postnet.util.PaymentMethod;

import java.sql.Time;
import java.util.Date;

public class AppointmentResponse {
    private Long id;
    private Integer cost;
    private Date dueDate;
    private Time startTime;
    private Time endTime;
    private MedicResponse medics;
    private PatientResponse patient;
    private PaymentMethod paymentMethod;
    private PrescriptionResponse prescription;

    public PrescriptionResponse getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionResponse prescription) {
        this.prescription = prescription;
    }


    public Long getId() {
        return id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public MedicResponse getMedics() {
        return medics;
    }

    public void setMedics(MedicResponse medics) {
        this.medics = medics;
    }

    public PatientResponse getPatient() {
        return patient;
    }

    public void setPatient(PatientResponse patient) {
        this.patient = patient;
    }


}
