package com.example.sq_ch11_payments.controllers;

import com.example.sq_ch11_payments.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    Logger logger = Logger.getLogger(PaymentController.class.getName());


    @PostMapping("/payment")
    public ResponseEntity<Payment> payment(@RequestHeader String requestId, @RequestBody Payment payment){


        logger.info("Request Id: " + requestId + "\nPayment Amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity.status(HttpStatus.ACCEPTED).header("requestId", requestId).body(payment);
    }
}
