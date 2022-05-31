package com.api.postnet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionResponse {
    private Long id;
    private AppointmentResponse appointment;
    private String description;
    private List<PrescriptionMedicinesResponse> prescriptionMedicines;
}
