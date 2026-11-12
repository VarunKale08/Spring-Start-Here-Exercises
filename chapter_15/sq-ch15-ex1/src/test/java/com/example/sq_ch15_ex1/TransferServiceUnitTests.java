package com.example.sq_ch15_ex1;

import com.example.sq_ch15_ex1.exceptions.AccountNotFoundException;
import com.example.sq_ch15_ex1.models.Account;
import com.example.sq_ch15_ex1.repositories.AccountReposiotry;
import com.example.sq_ch15_ex1.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.awaitility.Awaitility.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {

    @Mock
    private AccountReposiotry accountReposiotry;

    @InjectMocks
    private TransferService transferService;

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void transferMoneyHappyFlow(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        given(accountReposiotry.findById(sender.getId()))
                .willReturn(Optional.of(sender));

        given(accountReposiotry.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferService.transfer(sender.getId(), receiver.getId(), new BigDecimal(100));

        verify(accountReposiotry).changeAccount(1, new BigDecimal(900));
        verify(accountReposiotry).changeAccount(2, new BigDecimal(1100));
    }


    @Test
    @DisplayName("Test the amount is transferred from one account to another, but the reciver id retrival fails leading to accountnot found exception.")
    public void transferMoneyExceptionFlow(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account reciver = new Account();
        reciver.setId(2);
        reciver.setAmount(new BigDecimal(1000));


        given(accountReposiotry.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountReposiotry.findById(sender.getId())).willReturn(Optional.empty());


        assertThrows(AccountNotFoundException.class, () -> transferService.transfer(1, 2, new BigDecimal(100)));

        verify(accountReposiotry, never()).changeAccount(anyLong(), any());
    }
}
