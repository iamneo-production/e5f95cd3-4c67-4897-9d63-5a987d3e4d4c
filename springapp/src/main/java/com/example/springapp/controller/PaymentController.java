package com.example.springapp.controller;

import com.example.springapp.model.PaymentData;
import com.example.springapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  @Autowired
  private PaymentRepository paymentRepository;

  @PostMapping
  public String processPayment(@RequestBody PaymentData paymentData) {
    // Store paymentDetails in the database
    paymentRepository.save(paymentData);
    return "Payment successful";
  }
}
