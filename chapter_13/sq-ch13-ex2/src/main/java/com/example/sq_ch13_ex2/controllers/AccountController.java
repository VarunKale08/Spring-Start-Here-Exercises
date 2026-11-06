package com.example.sq_ch13_ex2.controllers;

import com.example.sq_ch13_ex2.dto.TransferRequest;
import com.example.sq_ch13_ex2.models.Account;
import com.example.sq_ch13_ex2.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        this.transferService.transferMoney(transferRequest.getSenderId(), transferRequest.getRecieverId(), transferRequest.getTransferAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAccount(){
        return this.transferService.getAllAccounts();
    }
}
