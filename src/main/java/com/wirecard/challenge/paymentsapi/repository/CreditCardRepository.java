package com.wirecard.challenge.paymentsapi.repository;


import com.wirecard.challenge.paymentsapi.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
