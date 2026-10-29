package com.example.sq_ch10_ex6.controllers.advice;

import com.example.sq_ch10_ex6.controllers.MoneyPaymentController;
import com.example.sq_ch10_ex6.errors.NotEnoughMoneyException;
import com.example.sq_ch10_ex6.models.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpectionHandlerAdvice {


    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorMessage> exception(){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("error occured while payment");
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
