package com.api.postnet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionRequest {
    @NotNull
    private Long appointment_id;
    @NotNull
    private String description;
}
