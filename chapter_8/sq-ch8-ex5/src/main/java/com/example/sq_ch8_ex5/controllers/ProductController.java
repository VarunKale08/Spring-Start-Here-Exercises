package com.example.sq_ch8_ex5.controllers;


import com.example.sq_ch8_ex5.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sq_ch8_ex5.services.ProductService;

@Controller
public class ProductController {


    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        var products = this.productService.getProducts();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(Model model, @RequestParam String name, @RequestParam double price){

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        this.productService.addProduct(product);

        var products = this.productService.getProducts();

        model.addAttribute("products", products);

        return "products.html";
    }


}
