package com.example.sq_ch9_ex2.controllers;

import com.example.sq_ch9_ex2.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }


    @GetMapping("/main")
    public String mainGet(@RequestParam(required = false) String logout, Model model){

        if(logout != null){
            this.loggedUserManagementService.setUsername(null);
        }


        String username = this.loggedUserManagementService.getUsername();

        if(username==null){
            return "redirect:/";
        }


        model.addAttribute("username", username);

        return "main.html";
    }

}
