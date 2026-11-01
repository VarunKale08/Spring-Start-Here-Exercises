package com.example.sq_ch12_ex1.controllers;

import com.example.sq_ch12_ex1.models.Purchase;
import com.example.sq_ch12_ex1.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }


    @PostMapping
    public void storePurchaseRecord(@RequestBody Purchase purchase){
        this.purchaseRepository.storeProduct(purchase);
    }

    @GetMapping
    public List<Purchase> getRecords(){
        return this.purchaseRepository.finadAllPurchases();
    }
}
