package com.api.postnet.dto;

public class AppoimentRequest {

    private Long medic_id;
    private Long patient_id;
    private Long payment_id;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getMedic_id() {
        return medic_id;
    }

    public void setMedic_id(Long medic_id) {
        this.medic_id = medic_id;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

}
