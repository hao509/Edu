package com.yang.edu.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : MrYang
 * @Description :
 * @Date :2019-11-21
 **/
@Controller
@RequestMapping("/news")
public class NewsController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String news(HttpServletRequest request){
        //student-新生导读，school-学院新闻
        String type = request.getParameter("type");
        if("student".equals(type)){

        }else{

        }
        return "news";
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id")String id, HttpServletRequest request){

        return "detail";
    }
}
