package com.wirecard.challenge.paymentsapi.repository;


import com.wirecard.challenge.paymentsapi.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {

}
