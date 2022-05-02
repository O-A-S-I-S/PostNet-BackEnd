package com.api.postnet.diagnosis.entities;

import lombok.Data;

import java.util.Date;

public class Appointment {
    private Integer appointment_id;
    private Date due_date;

    public Integer getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
}
