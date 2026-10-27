package com.example.sq_ch9_ex3.models;

import com.example.sq_ch9_ex3.services.LoggedUserManagementService;
import com.example.sq_ch9_ex3.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
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

    public boolean login(){

        this.loginCountService.increment();

        String username = this.getUsername();
        String password = this.getPassword();

        boolean isValid = false;

        if(username.equals("natalie") &&  password.equals("password")){
            isValid= true;
            this.loggedUserManagementService.storeUsername(username);
        }

        return isValid;
    }
}
