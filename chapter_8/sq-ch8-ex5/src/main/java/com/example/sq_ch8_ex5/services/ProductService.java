package com.example.sq_ch8_ex5.services;

import com.example.sq_ch8_ex5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        this.productList.add(product);
    }

    public List<Product> getProducts(){
        return this.productList;
    }

}
