package com.yang.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/login")
public class Login {
    @RequestMapping("")
    @ResponseBody
    public boolean login(){
        System.out.println("ok");
        return true;
    }
}
