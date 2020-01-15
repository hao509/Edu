package com.yang.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : MrYang
 * @Description :
 * @Date :
 **/
@Controller
public class IndexController {
    @RequestMapping("")
    public String test(ModelMap model){
        model.put("name","yang");
        System.out.println("进来了");
        return "index";
    }
}
