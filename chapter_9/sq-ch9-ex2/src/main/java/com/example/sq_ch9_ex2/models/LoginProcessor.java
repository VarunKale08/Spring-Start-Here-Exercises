package com.example.sq_ch9_ex2.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import com.example.sq_ch9_ex2.services.LoggedUserManagementService;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login(){

        String username = this.getUsername();
        String password = this.getPassword();

        boolean isValid = false;

        if(username.equals("natalie") && password.equals("password")){
            isValid=true;
            this.loggedUserManagementService.setUsername(username);
        }

        return isValid;
    }


    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }


}
