package com.wirecard.challenge.paymentsapi.repository;


import com.wirecard.challenge.paymentsapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
