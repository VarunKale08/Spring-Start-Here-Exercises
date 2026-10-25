package com.example.sq_ch8_ex2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(Model page, @RequestParam String color){
        page.addAttribute("username", "varun");
        page.addAttribute("color", color);
        return "home.html";
    }
}
