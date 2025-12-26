package com.itlaoqi.envdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Value("${my.database.ip}")
    private String ip;

    @GetMapping("/")
    public String out(){
        return ip;
    }
}
