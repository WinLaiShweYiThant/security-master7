package com.example.securitymaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @GetMapping({"/","/home"})
    public String index(){
        return "index";
    }
}
