package com.api.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineItem {
    private int quantity;
    private PrescriptionResponse prescription;
}
