package com.api.postnet.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class PrescriptionResponse {
    private Long prescriptionId;
    private String prescriptionDescription;
    private List<PrescriptionMedicinesResponse> prescriptionMedicinesResponses;
}
