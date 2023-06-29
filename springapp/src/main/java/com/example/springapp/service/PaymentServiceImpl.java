package com.example.springapp.service;

import com.example.springapp.model.Payment;
import com.example.springapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentsRepository;

    @Override
    public Payment savePayment(Payment payments) {
        return paymentsRepository.save(payments);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }
}