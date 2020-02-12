package com.wirecard.challenge.paymentsapi.repository;


import com.wirecard.challenge.paymentsapi.model.Holder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolderRepository extends JpaRepository<Holder, Long> {

}
