package com.example.sq_ch10_ex5.services;


import com.example.sq_ch10_ex5.errors.NotEnoughMoneyException;
import com.example.sq_ch10_ex5.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}