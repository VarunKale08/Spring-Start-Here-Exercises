package com.example.sq_ch12_ex1.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Purchase {

    private int id;
    private String product;
    private BigDecimal price;


    public void setId(int id){
        this.id = id;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }


    public int getId(){
        return this.id;
    }

    public String getProduct(){
        return this.product;
    }

    public BigDecimal getPrice(){
        return this.price;
    }


    @Override
    public boolean equals(Object comapredObj){
        if(this == comapredObj){
            return true;
        }

        if(!(comapredObj instanceof Purchase)){
            return false;
        }

        Purchase newObj = (Purchase) comapredObj;

        return this.getId() == newObj.getId() && this.getProduct().equals(newObj.getProduct()) && this.getPrice() == newObj.getPrice();
    }


    @Override
    public int hashCode(){
        return Objects.hash(id, product, price);
    }
}
