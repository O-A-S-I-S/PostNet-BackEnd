package com.api.postnet.controllers;

import com.api.postnet.dto.MedicResponse;
import com.api.postnet.dto.PaymentMethodResponse;
import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Payment_method;
import com.api.postnet.services.PatientService;
import com.api.postnet.services.PaymentMethodService;
import com.api.postnet.util.EntityDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentMethodController {
    private PaymentMethodService paymentMethodService;
    private EntityDtoConverter converter;
    public PaymentMethodController(PaymentMethodService paymentMethodService, EntityDtoConverter converter){
        this.paymentMethodService=paymentMethodService;
        this.converter=converter;
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodResponse> findPaymentMethodById(@PathVariable Long id){
        Payment_method payment_method =paymentMethodService.getPaymentMethodById(id);

        return new ResponseEntity(converter.convertEntityToDto(payment_method), HttpStatus.OK);
    }
}
