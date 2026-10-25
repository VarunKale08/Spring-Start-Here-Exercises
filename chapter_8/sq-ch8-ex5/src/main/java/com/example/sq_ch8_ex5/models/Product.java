package com.example.sq_ch8_ex5.models;

public class Product {

    private String name;
    private double price;

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
}
