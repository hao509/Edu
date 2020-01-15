package com.yang.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : MrYang
 * @Description : 公共控制器
 * @Date : 2019-11-22
 **/
@Controller
public class CommonController {

    @RequestMapping(value = "/head",method = RequestMethod.GET)
    public String head(){
        return "head";
    }
    @RequestMapping(value = "/foot",method = RequestMethod.GET)
    public String foot(){
        return "foot";
    }

}
