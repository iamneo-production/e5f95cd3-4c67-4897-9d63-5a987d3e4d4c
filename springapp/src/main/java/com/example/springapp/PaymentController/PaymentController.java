package com.example.springapp.PaymentController;
import com.example.springapp.DTO.PaymentDTO;
import com.example.springapp.DTO.PaymentSaveDTO;
import com.example.springapp.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/payments")
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;
    @PostMapping(path = "/save")
    public String savePayment(@RequestBody PaymentSaveDTO paymentSaveDTO)
    {
        String id = paymentService.addPayment(paymentSaveDTO);
        return id;
    }
}