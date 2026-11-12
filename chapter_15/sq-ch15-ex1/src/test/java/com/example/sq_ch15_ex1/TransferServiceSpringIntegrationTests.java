package com.example.sq_ch15_ex1;

import com.example.sq_ch15_ex1.models.Account;
import com.example.sq_ch15_ex1.repositories.AccountReposiotry;
import com.example.sq_ch15_ex1.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {

    @MockitoBean
    private AccountReposiotry accountReposiotry;

    @Autowired
    private TransferService transferService;

    @Test
    @DisplayName("Implementing integration test to check working of TransferService and AccountRepository")
    void transferServiceTransferAmountTest(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account reciver = new Account();
        reciver.setId(2);
        reciver.setAmount(new BigDecimal(1000));


        when(accountReposiotry.findById(1L)).thenReturn(Optional.of(sender));
        when(accountReposiotry.findById(2L)).thenReturn(Optional.of(reciver));


        transferService.transfer(1, 2, new BigDecimal(1000));

        verify(accountReposiotry).changeAccount(1,new BigDecimal(900));
        verify(accountReposiotry).changeAccount(2, new BigDecimal(1100));
    }
}
