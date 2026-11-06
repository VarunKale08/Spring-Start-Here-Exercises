package com.example.sq_ch13_ex2.models;

import java.math.BigDecimal;

public class Account {

    private long id;
    private String name;
    private BigDecimal amount;

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }
}
