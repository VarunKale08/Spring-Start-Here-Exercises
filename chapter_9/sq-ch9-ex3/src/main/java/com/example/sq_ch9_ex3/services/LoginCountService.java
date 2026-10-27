package com.example.sq_ch9_ex3.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {

    private int loginCount;


    public int getCount(){
        return this.loginCount;
    }

    public void increment(){
        this.loginCount++;
    }
}
