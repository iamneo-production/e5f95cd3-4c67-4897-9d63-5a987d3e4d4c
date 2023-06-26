package com.example.springapp.controller;

import com.example.springapp.model.Payment;
import com.example.springapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public String save(@RequestBody Payment payment){
        paymentService.savePayment(payment);
        return "New payment is added";
    }

    @GetMapping("/getAll")
    public List<Payment> list(){
        return paymentService.getAllPayments();
    }
}