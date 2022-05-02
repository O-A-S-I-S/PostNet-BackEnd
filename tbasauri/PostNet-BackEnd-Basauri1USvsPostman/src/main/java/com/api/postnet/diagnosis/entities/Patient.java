package com.api.postnet.diagnosis.entities;

import lombok.Data;

import java.util.List;


public class Patient {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String PatientID;

    @OneToOne
    private ClinicHistory clinicHistory;
    @OneToMany
    private List<Diagnosis> diagnoses;*/
    private String person_id;
    private Integer blood_type_id;

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public Integer getBlood_type_id() {
        return blood_type_id;
    }

    public void setBlood_type_id(Integer blood_type_id) {
        this.blood_type_id = blood_type_id;
    }
}
