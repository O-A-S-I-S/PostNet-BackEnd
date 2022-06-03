package com.api.postnet.dto;

import com.api.postnet.entities.Appointment;

import com.api.postnet.entities.Medicine;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PrescriptionRequest {
    @NotNull
    private Long appointment_id;
    @NotNull
    private String description;

}