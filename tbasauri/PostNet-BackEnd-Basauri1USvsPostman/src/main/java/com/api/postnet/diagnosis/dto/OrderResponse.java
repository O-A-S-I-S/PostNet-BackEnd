package com.api.postnet.diagnosis.dto;

import com.api.postnet.diagnosis.entities.Appointment;
import com.api.postnet.diagnosis.entities.Medic;

public class OrderResponse {
    public Appointment appointment;
    public Medic medic;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }
}
