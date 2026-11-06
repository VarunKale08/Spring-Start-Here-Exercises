package com.example.sq_ch13_ex2.dto;

import java.math.BigDecimal;

public class TransferRequest {

    private long senderId;
    private long recieverId;
    private BigDecimal transferAmount;

    public void setSenderId(long senderId){
        this.senderId = senderId;
    }

    public long getSenderId(){
        return this.senderId;
    }

    public void setRecieverId(long recieverId){
        this.recieverId = recieverId;
    }

    public long getRecieverId(){
        return this.recieverId;
    }

    public void setTransferAmount(BigDecimal transferAmount){
        this.transferAmount = transferAmount;
    }

    public BigDecimal getTransferAmount(){
        return this.transferAmount;
    }
}
