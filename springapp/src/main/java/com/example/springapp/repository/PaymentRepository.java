package com.example.springapp.repository;

import com.example.springapp.model.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentData, Long> {
}
