package com.api.tp.dto;

import lombok.Data;

import java.util.List;

@Data
public class PrescriptionRequest {
    private String description;
    private List<LineItem>items;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
