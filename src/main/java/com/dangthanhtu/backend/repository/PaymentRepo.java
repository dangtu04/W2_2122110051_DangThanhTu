package com.dangthanhtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dangthanhtu.backend.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}