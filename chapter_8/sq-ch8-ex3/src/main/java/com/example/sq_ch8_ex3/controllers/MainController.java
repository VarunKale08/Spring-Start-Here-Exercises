package com.example.sq_ch8_ex3.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(@RequestParam String color, @RequestParam String username, Model page){
        page.addAttribute("username", username);
        page.addAttribute("color", color);
        return "home.html";
    }

}
