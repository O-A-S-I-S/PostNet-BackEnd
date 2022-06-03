package com.api.postnet.repository;

import com.api.postnet.entities.Payment_method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentMethodRepository extends JpaRepository<Payment_method,Long> {
    @Query("SELECT o From Payment_method  o WHERE o.id=:paymentMethodId")
    Payment_method findPaymentMethodById(@Param("paymentMethodId") Long paymentMethodId);

}
