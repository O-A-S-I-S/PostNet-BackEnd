package com.api.postnet.util;

import com.api.postnet.dto.PrescriptionRequest;
import com.api.postnet.exceptions.IncorrectPrescriptionRequestException;

public class PrescriptionValidator {
    public static boolean validatePrescription(PrescriptionRequest prescription){
        if(prescription.getDescription()==null|| prescription.getDescription().isEmpty()){
            throw new IncorrectPrescriptionRequestException("Error al momento de cargar la prescripcion");
        }
        return true;
    }
}
