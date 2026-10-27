package com.example.sq_ch9_ex3.controllers;

import com.example.sq_ch9_ex3.services.LoggedUserManagementService;
import com.example.sq_ch9_ex3.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private LoggedUserManagementService loggedUserManagementService;
    private LoginCountService loginCountService;


    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }


    @GetMapping("/main")
    public String homeGet(@RequestParam(required = false) String logout, Model model){
        if(logout!= null){
            this.loggedUserManagementService.storeUsername(null);
        }


        String username = this.loggedUserManagementService.getUsername();
        int loginCount = this.loginCountService.getCount();

        if(username == null){
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", loginCount);
        return "main";
    }
}
