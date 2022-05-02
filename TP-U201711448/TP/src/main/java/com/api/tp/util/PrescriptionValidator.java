package com.api.tp.util;

import com.api.tp.dto.PrescriptionRequest;
import com.api.tp.exception.IncorrectPrescriptionRequestException;

public class PrescriptionValidator {
    public static boolean validatePrescription(PrescriptionRequest prescription){
        if(prescription.getItems()==null || prescription.getItems().isEmpty()){
            throw new IncorrectPrescriptionRequestException("Error al momento de cargar la prescripcion");
        }
        return true;
    }
}
