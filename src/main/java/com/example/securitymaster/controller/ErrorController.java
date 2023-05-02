package com.example.securitymaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(Throwable.class)
    public String exception(Throwable t, HttpServletResponse response, Model model){
//        String cause=t !=null ? t.getCause().getMessage() : "unknown cause";
//        model.addAttribute("cause",cause);
        String msg=t !=null ? t.getMessage() : "Unknown Message";
        model.addAttribute("msg",msg);
        int code=switch (msg){
            case  "Unknown Error!" -> 500;
            case "Access is denied" -> 403;
            default -> 500;
        };
        model.addAttribute("statusCode",response.getStatus());

        return "error";
    }
}

