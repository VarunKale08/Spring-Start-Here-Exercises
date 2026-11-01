package com.example.sq_ch12_ex3.models;

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
    public boolean equals(Object customObj){
        if(this == customObj){
            return true;
        }

        if(!(customObj instanceof Purchase)){
            return true;
        }

        Purchase typeCastedObject = (Purchase) customObj;

        return this.getId() == typeCastedObject.getId() && this.getPrice() == typeCastedObject.getPrice() && this.getProduct().equals(typeCastedObject.getProduct());
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, product, price);
    }
}
