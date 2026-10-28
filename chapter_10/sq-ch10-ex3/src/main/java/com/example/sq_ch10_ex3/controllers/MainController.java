package com.example.sq_ch10_ex3.controllers;

import com.example.sq_ch10_ex3.models.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @GetMapping("/france")
    public Country france(){
        Country c = Country.of("france", 20000);
        return c;
    }


    @GetMapping("/all")
    public List<Country> all(){
        Country c1 = Country.of("uk", 30000);
        Country c2 = Country.of("france", 30009);

        List<Country> list = List.of(c1, c2);

        return list;
    }

}
