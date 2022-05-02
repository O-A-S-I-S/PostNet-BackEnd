package com.api.postnet.diagnosis.dto;

import com.api.postnet.diagnosis.entities.Medic;
import lombok.Data;

public class OrderRequest {
    private Medic medic;

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }
}
