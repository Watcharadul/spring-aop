package com.go.basic.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String getMyService(){
        return "My Hero.";
    }

    public Integer getMyError(){
        return Integer.valueOf("S");
    }
}
