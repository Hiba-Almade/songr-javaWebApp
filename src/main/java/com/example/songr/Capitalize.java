package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Capitalize {

    @GetMapping("/capitalize/{text}")
    public String capitalizeWord(Model model , @PathVariable String text){
        String result = text.toUpperCase();
        model.addAttribute("text", result);
        return "capitalize.html";
    }
}
