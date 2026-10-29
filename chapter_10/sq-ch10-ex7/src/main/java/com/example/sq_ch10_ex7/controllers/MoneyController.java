package com.example.sq_ch10_ex7.controllers;

import com.example.sq_ch10_ex7.models.PaymentDeatils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MoneyController {


    private static Logger logger = Logger.getLogger(MoneyController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<PaymentDeatils> payment(@RequestBody PaymentDeatils paymentDeatils){
        logger.info("Amount recieved: " + paymentDeatils.getMoney());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDeatils);
    }

}
