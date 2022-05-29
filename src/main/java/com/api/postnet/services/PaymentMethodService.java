package com.api.postnet.services;

import com.api.postnet.entities.Patient;
import com.api.postnet.entities.Payment_method;
import com.api.postnet.repository.PatientRepository;
import com.api.postnet.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PaymentMethodService {
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository){this.paymentMethodRepository=paymentMethodRepository;}


    @Transactional
    public Payment_method getPaymentMethodById(Long paymentId){
        return paymentMethodRepository.findPaymentMethodById(paymentId);
    }
}
