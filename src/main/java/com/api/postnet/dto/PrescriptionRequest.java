package com.api.postnet.dto;

import com.api.postnet.entities.Appointment;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PrescriptionRequest {
    @NotNull
    private Appointment appointment_id;
    @NotNull
    private String description;

}
