package com.example.sq_ch10_ex6.controllers;

import com.example.sq_ch10_ex6.models.Money;
import com.example.sq_ch10_ex6.services.MoneyProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyPaymentController {

    private final MoneyProcessService moneyProcessService;

    public MoneyPaymentController(MoneyProcessService moneyProcessService){
        this.moneyProcessService = moneyProcessService;
    }


    @PostMapping("/payment")
    public ResponseEntity<Money> payment(){
        Money money = this.moneyProcessService.processPayment();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(money);
    }

}
