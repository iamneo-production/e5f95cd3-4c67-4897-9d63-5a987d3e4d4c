package com.example.springapp.service;

import com.example.springapp.model.Payment;

import java.util.List;

public interface PaymentService {
    public Payment savePayment(Payment payment);
    public List<Payment> getAllPayments();
}
