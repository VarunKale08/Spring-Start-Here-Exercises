package com.example.sq_ch9_ex1.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;


    public void setUsername(String username){
        this.username= username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }


    public boolean login(){

        if("natalie".equals(this.getUsername()) && "password".equals(this.getPassword())){
            return true;
        } else{
            return false;
        }
    }

}
