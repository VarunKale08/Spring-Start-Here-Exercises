package com.example.sq_ch10_ex2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/home")
    public String hello(){
        return "hello";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "ciao";
    }

}
