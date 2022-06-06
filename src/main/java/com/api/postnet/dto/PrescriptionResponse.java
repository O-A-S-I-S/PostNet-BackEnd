package com.api.postnet.dto;

import com.api.postnet.entities.Appointment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PrescriptionResponse {
    private Long id;
    private String description;
    private List<PrescriptionMedicinesResponse> prescriptionMedicines;
}