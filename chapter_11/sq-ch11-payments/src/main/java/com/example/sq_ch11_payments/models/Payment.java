package com.example.sq_ch11_payments.models;

public class Payment {

    private String id;
    private int amount;


    public void setId(String id){
        this.id = id;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }


    public String getId(){
        return this.id;
    }

    public int getAmount(){
        return this.amount;
    }
}
