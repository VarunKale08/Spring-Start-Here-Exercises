package com.example.sq_ch14_ex1.dto;

import java.math.BigDecimal;

public class TransferRequest {

    private long senderId;
    private long reciverId;
    private BigDecimal amount;


    public void setSenderId(long senderId){
        this.senderId = senderId;
    }

    public long getSenderId(){
        return this.senderId;
    }

    public void setReciverId(long reciverId){
        this.reciverId = reciverId;
    }

    public long getReciverId(){
        return this.reciverId;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

}
