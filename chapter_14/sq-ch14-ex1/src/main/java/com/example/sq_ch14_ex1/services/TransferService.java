package com.example.sq_ch14_ex1.services;

import com.example.sq_ch14_ex1.exceptions.AccountNotFoundException;
import com.example.sq_ch14_ex1.models.Account;
import com.example.sq_ch14_ex1.repositories.AccountRepository;
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

    @Transactional
    public void transferMoney(long idSender, long idReciver, BigDecimal amount){
        Account sender = this.accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());

        Account reciver = this.accountRepository.findById(idReciver).orElseThrow(() -> new AccountNotFoundException());


        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal reciverNewAmount = reciver.getAmount().add(amount);

        accountRepository.changeAmount(senderNewAmount, idSender);
        accountRepository.changeAmount(reciverNewAmount, idReciver);
    }


    public Iterable<Account> getAllAccounts(){
        return this.accountRepository.findAll();
    }


    public List<Account> findAccountByNames(String name) {
        return this.accountRepository.findAccountByNames(name);
    }
}
