package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloboot {
    @RequestMapping("/h")
    public String abc(){
        return "你好，你已经搭好了Spring Boot";
    }
}