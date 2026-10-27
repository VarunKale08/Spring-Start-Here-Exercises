package com.example.sq_ch9_ex3.controllers;

import com.example.sq_ch9_ex3.models.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model){

        this.loginProcessor.setUsername(username);
        this.loginProcessor.setPassword(password);

        boolean correctCredentials = this.loginProcessor.login();

        if(correctCredentials){
            return "redirect:/main";
        }

        model.addAttribute("message", "Invalid Login");
        return "login";
    }


}
