package com.example.sq_ch9_ex2.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUserManagementService {

    private String username;


    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

}
