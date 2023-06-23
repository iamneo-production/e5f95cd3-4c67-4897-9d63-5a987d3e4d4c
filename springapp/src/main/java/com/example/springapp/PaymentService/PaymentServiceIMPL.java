package com.example.springapp.Service;

import com.example.springapp.PaymentRepo.PaymentRepo;
import com.example.springapp.DTO.PaymentDTO;
import com.example.springapp.DTO.PaymentSaveDTO;
import com.example.springapp.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceIMPL implements PaymentService
{
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public String addPayment(PaymentSaveDTO paymentSaveDTO)
    {
        Payment payment = new Payment(

                paymentSaveDTO.getPaymentMode(),
                paymentSaveDTO.getCardname(),
                paymentSaveDTO.getCardnumber(),
                paymentSaveDTO.getExpirationDate(),
                paymentSaveDTO.getCVV(),
                paymentSaveDTO.getUPI()
        );
        paymentRepo.save(payment);
        return payment.getCardname();
    }   
}