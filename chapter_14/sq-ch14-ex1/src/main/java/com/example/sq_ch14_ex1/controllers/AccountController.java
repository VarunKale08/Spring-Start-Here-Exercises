package com.example.sq_ch14_ex1.controllers;

import com.example.sq_ch14_ex1.dto.TransferRequest;
import com.example.sq_ch14_ex1.models.Account;
import com.example.sq_ch14_ex1.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        this.transferService.transferMoney(transferRequest.getSenderId(), transferRequest.getReciverId(), transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(@RequestParam(required = false) String name){
        if(name == null){
            return this.transferService.getAllAccounts();
        } else {
            return this.transferService.findAccountByNames(name);
        }
    }

}
