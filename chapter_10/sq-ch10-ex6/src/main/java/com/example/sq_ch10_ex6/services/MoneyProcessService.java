package com.example.sq_ch10_ex6.services;

import com.example.sq_ch10_ex6.errors.NotEnoughMoneyException;
import com.example.sq_ch10_ex6.models.Money;
import org.springframework.stereotype.Service;

@Service
public class MoneyProcessService {


    public Money processPayment(){
        throw new NotEnoughMoneyException();
    }
}
