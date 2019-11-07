package com.yang.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : MrYang
 * @Description :
 * @Date : 2019-11-07
 **/
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("")
    public String homePage(Model model){
        model.addAttribute("name","MrYang");
        return "home";
    }
}
