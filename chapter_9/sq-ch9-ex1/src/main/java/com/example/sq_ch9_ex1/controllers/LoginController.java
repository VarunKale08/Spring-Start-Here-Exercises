package com.example.sq_ch9_ex1.controllers;

import com.example.sq_ch9_ex1.models.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    private LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor= loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }


    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model){

        this.loginProcessor.setUsername(username);
        this.loginProcessor.setPassword(password);
        boolean correctCredentendials = this.loginProcessor.login();

        if(correctCredentendials){
            model.addAttribute("message", "Username and password is correct.");
        } else{
            model.addAttribute("message", "Username and password is incorrect.");
        }

        return "login.html";
    }

}
