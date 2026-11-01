package com.example.sq_ch12_ex2.controllers;

import com.example.sq_ch12_ex2.models.Purchase;
import com.example.sq_ch12_ex2.repositories.PurchaseRepository;
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
    public void postPurchaseRecord(@RequestBody Purchase purchase){
        this.purchaseRepository.storePurchaseRecord(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchaseRecords(){
        return this.purchaseRepository.getPurchaseRecords();
    }

}
