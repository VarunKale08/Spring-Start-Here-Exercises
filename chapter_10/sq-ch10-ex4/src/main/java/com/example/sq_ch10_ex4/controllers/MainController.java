package com.example.sq_ch10_ex4.controllers;

import com.example.sq_ch10_ex4.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/france")
    public ResponseEntity<Country> france(){
        Country c = Country.of("france", 2000);
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("capital", "paris").header("food", "bagutte").body(c);
    }

}
