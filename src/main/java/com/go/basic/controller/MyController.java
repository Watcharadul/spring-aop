package com.go.basic.controller;

import com.go.basic.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService service;

    @Autowired
    public MyController(MyService service){
        this.service = service;
    }

    @GetMapping
    public String getMyController(){
        return service.getMyService();
    }

    @GetMapping("/error")
    public Integer getMyError(){
        return service.getMyError();
    }

}
