package com.example.sq_ch12_ex2.models;

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
    public boolean equals(Object compareObj){
        if(this == compareObj){
            return true;
        }

        if(!(compareObj instanceof Purchase)){
            return false;
        }

        Purchase typeCastObj = (Purchase) compareObj;

        return this.getId() == typeCastObj.getId() && this.getProduct().equals(typeCastObj.getProduct()) && this.getPrice() == typeCastObj.getPrice();

    }

    @Override
    public int hashCode(){
        return Objects.hash(id, product, price);
    }
}
