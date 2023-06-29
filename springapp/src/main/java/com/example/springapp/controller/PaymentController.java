package com.example.springapp.controller;

import com.example.springapp.model.Payment;
import com.example.springapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentsService;

    @PostMapping("/save")
    public String save(@RequestBody Payment payments){
        paymentsService.savePayment(payments);
        return "New Payment is added";
    }

    @GetMapping("/getAll")
    public List<Payment> list(){
        return paymentsService.getAllPayments();
    }
}