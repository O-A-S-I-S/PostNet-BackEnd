package com.api.postnet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionMedicinesResponse {
    private String nameMedicine;
}