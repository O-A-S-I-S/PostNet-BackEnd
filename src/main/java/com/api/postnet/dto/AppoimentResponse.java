package com.api.postnet.dto;

import com.api.postnet.entities.Medic;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Payment_method;

import java.sql.Time;
import java.util.Date;

public class AppoimentResponse {
    private Long id;
    private Integer cost;
    private Date dueDate;
    private Time startTime;
    private Time endTime;
    private Medic medics;
    private Patient patient;

    public Long getId() {
        return id;
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

    public Medic getMedics() {
        return medics;
    }

    public void setMedics(Medic medics) {
        this.medics = medics;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment_method getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment_method paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private Payment_method paymentMethod;
}
