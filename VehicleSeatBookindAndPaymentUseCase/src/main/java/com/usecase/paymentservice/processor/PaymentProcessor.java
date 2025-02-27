package com.usecase.paymentservice.processor;

import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    public String processPayment(Double amount) {
        // Simulate payment processing
        if (amount > 0) {
            return "SUCCESS";
        }
        return "FAILED";
    }
}