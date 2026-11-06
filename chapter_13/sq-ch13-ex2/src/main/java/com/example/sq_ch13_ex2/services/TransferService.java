package com.example.sq_ch13_ex2.services;

import com.example.sq_ch13_ex2.dto.TransferRequest;
import com.example.sq_ch13_ex2.models.Account;
import com.example.sq_ch13_ex2.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return this.accountRepository.findAllAccounts();
    }

    @Transactional
    public void transferMoney(long senderId, long recieverId, BigDecimal amount){
        Account senderAccount = this.accountRepository.finalAccountById(senderId);
        Account reciverAccount = this.accountRepository.finalAccountById(recieverId);

        senderAccount.getAmount().subtract(amount);
        reciverAccount.getAmount().add(amount);

        this.accountRepository.changeAmount(senderId, senderAccount.getAmount());
        this.accountRepository.changeAmount(recieverId, reciverAccount.getAmount());

        throw new RuntimeException("Oh no! Something went wrong!");
    }
}
