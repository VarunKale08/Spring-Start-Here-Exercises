package com.example.sq_ch15_ex1.services;

import com.example.sq_ch15_ex1.exceptions.AccountNotFoundException;
import com.example.sq_ch15_ex1.models.Account;
import com.example.sq_ch15_ex1.repositories.AccountReposiotry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountReposiotry accountReposiotry;

    public TransferService(AccountReposiotry accountReposiotry){
        this.accountReposiotry = accountReposiotry;
    }

    @Transactional
    public void transfer(long senderId, long receiverId, BigDecimal amount){

        Account sender = this.accountReposiotry.findById(senderId).orElseThrow(() -> new AccountNotFoundException());

        Account receiver = this.accountReposiotry.findById(receiverId).orElseThrow(() -> new AccountNotFoundException());


        BigDecimal newSenderAmount = sender.getAmount().subtract(amount);
        BigDecimal newRecieverAmount = receiver.getAmount().add(amount);

        this.accountReposiotry.changeAccount(senderId, newSenderAmount);
        this.accountReposiotry.changeAccount(receiverId, newRecieverAmount);

    }


    public Iterable<Account> findAllAccounts(){
        return this.accountReposiotry.findAll();
    }

    public List<Account> findAccountByName(String name){
        return this.accountReposiotry.findAccountsByName(name);
    }

}
