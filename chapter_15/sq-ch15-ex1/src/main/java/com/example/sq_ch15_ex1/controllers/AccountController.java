package com.example.sq_ch15_ex1.controllers;

import com.example.sq_ch15_ex1.dto.TransferRequest;
import com.example.sq_ch15_ex1.models.Account;
import com.example.sq_ch15_ex1.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountController {

    private TransferService transferService;

    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }


    @PostMapping("/payment")
    public void payment(@RequestBody TransferRequest transferRequest){
            this.transferService.transfer(transferRequest.getSenderId(), transferRequest.getRecieverId(), transferRequest.getTransferAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(@RequestParam(required = false) String name){

        if(name != null){
            return this.transferService.findAccountByName(name);
        } else{
            return this.transferService.findAllAccounts();
        }

    }
}
