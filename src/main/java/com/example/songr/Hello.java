package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

@GetMapping("/hello")
    public String helloWorld(){
    return "hello.html";
}
}
