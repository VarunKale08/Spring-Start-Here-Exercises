package com.example.sq_ch8_ex6.controllers;

import com.example.sq_ch8_ex6.models.Product;
import com.example.sq_ch8_ex6.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductControllers {


    private ProductService productService;

    public ProductControllers(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){

        var products = this.productService.getProduct();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(Model model, String name, double price){

        Product product = new Product();

        product.setName(name);
        product.setPrice(price);
        this.productService.addProduct(product);

        var products = this.productService.getProduct();

        model.addAttribute("products", products);

        return "products.html";
    }

}
