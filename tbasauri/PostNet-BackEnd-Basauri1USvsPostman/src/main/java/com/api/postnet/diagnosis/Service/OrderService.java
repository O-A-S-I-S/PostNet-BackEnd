package com.api.postnet.diagnosis.Service;

import com.api.postnet.diagnosis.dto.OrderRequest;
import com.api.postnet.diagnosis.entities.medic_appointment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService {
    public medic_appointment createOrder(@RequestBody OrderRequest orderRequest){

        medic_appointment  response = new medic_appointment();

        return response;
    }
}
