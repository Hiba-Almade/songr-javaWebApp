package com.example.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/hello")
    public String helloWorld(){
       return "hello.html";
    }
}
