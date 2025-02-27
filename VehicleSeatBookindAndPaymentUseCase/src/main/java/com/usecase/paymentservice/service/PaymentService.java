package com.usecase.paymentservice.service;

import com.usecase.paymentservice.entity.Payment;
import com.usecase.paymentservice.processor.PaymentProcessor;
import com.usecase.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentProcessor paymentProcessor;

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        String status = paymentProcessor.processPayment(payment.getAmount());
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
}