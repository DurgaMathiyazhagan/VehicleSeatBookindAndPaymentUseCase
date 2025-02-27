package com.usecase.paymentservice.controller;

import com.usecase.paymentservice.entity.Payment;
import com.usecase.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/make")
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.makePayment(payment);
    }
}
