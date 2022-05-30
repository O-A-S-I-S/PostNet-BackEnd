package com.api.postnet.dto;

import com.api.postnet.entities.Appointment;
import lombok.Data;

import java.util.Date;
@Data
public class PrescriptionResponse {
    private Long id;
    private Appointment appointment_id;
    private String description;
}
