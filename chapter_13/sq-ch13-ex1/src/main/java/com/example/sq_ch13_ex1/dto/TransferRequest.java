package com.example.sq_ch13_ex1.dto;


import java.math.BigDecimal;

public class TransferRequest {

    private long senderAmountId;
    private long recieverAmountId;
    private BigDecimal amount;


    public void setSenderAmountId(long senderAmountId){
        this.senderAmountId = senderAmountId;
    }

    public long getSenderAmountId(){
        return this.senderAmountId;
    }

    public void setRecieverAmountId(long recieverAmountId){
        this.recieverAmountId = recieverAmountId;
    }

    public long getRecieverAmountId(){
        return this.recieverAmountId;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }


}
