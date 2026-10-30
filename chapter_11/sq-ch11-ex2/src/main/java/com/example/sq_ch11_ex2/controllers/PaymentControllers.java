package com.example.sq_ch11_ex2.controllers;

import com.example.sq_ch11_ex2.models.Payment;
import com.example.sq_ch11_ex2.proxies.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentControllers {

    private final PaymentProxy paymentProxy;

    public PaymentControllers(PaymentProxy paymentProxy){
        this.paymentProxy = paymentProxy;
    }


    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        return this.paymentProxy.createPayment(payment);
    }
}
