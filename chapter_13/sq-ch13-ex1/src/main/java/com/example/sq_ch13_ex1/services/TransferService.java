package com.example.sq_ch13_ex1.services;

import com.example.sq_ch13_ex1.models.Account;
import com.example.sq_ch13_ex1.repositories.AccountRepository;
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
        return this.accountRepository.findAllAccount();
    }

    @Transactional
    public void sendMoney(long requesterId, long recieverId, BigDecimal money){

        Account sender = this.accountRepository.findAccountByIds(requesterId);
        Account reciever = this.accountRepository.findAccountByIds(recieverId);

        BigDecimal newSenderAmount = sender.getAmount().subtract(money);
        BigDecimal newRecieverAmount = reciever.getAmount().add(money);

        this.accountRepository.changeAmount(requesterId, newSenderAmount);
        this.accountRepository.changeAmount(recieverId, newRecieverAmount);

    }
}
