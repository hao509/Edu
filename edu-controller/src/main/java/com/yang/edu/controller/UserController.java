package com.yang.edu.controller;

import com.yang.edu.entity.UserEntity;
import com.yang.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public List<UserEntity> getAllUser(){
        List<UserEntity> user = userService.getAllUser();
        return user;
    }

    @RequestMapping("/save")
    public void save(){
        UserEntity user = new UserEntity();
        user.setUserPassword("123456789");
        user.setUserName("yangwy");
        userService.save(user);

    }
}
