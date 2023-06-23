package com.example.springapp.Service;

import com.example.springapp.DTO.PaymentDTO;
import com.example.springapp.DTO.PaymentSaveDTO;

import java.util.List;

public interface PaymentService {
    String addPayment(PaymentSaveDTO paymentSaveDTO);
}