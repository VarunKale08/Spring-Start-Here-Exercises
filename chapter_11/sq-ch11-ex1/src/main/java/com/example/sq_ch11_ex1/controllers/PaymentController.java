package com.example.sq_ch11_ex1.controllers;

import com.example.sq_ch11_ex1.models.Payment;
import com.example.sq_ch11_ex1.proxies.PaymentsProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentsProxy paymentsProxy;

    public PaymentController(PaymentsProxy paymentsProxy){
        this.paymentsProxy = paymentsProxy;
    }


    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){

        String requestId = UUID.randomUUID().toString();

        return paymentsProxy.createPayment(requestId, payment);
    }
}
