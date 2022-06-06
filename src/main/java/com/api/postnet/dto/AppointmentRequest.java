package com.api.postnet.dto;

import com.api.postnet.util.PaymentMethod;

import java.sql.Date;
import java.sql.Time;


public class AppointmentRequest {


    private String medic_dni;
    private String patient_dni;
    private Long payment_id;
    private Time start_time;
    private Time end_time;
    private PaymentMethod paymentMethod;
    private Long prescription_id;


    public Long getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(Long prescription_id) {
        this.prescription_id = prescription_id;
    }



    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getMedic_dni() {
        return medic_dni;
    }

    public void setMedic_dni(String medic_dni) {
        this.medic_dni = medic_dni;
    }

    public String getPatient_dni() {
        return patient_dni;
    }

    public void setPatient_dni(String patient_dni) {
        this.patient_dni = patient_dni;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    private Integer cost;
    private Date due_date;
    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }



}
