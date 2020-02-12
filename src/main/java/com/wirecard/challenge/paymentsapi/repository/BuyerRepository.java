package com.wirecard.challenge.paymentsapi.repository;


import com.wirecard.challenge.paymentsapi.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
