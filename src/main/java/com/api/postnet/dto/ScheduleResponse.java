package com.api.postnet.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ScheduleResponse {
    private Date dueDate;
    private Time startTime;
    private Time endTime;
}
