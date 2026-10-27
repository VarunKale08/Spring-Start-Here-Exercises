package com.example.sq_ch9_ex3.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {

    private String username;


    public void storeUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
