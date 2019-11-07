/*
package com.yang.edu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class Login {

    */
/**
     * 登录逻辑处理
     * @return
     *//*

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(String name, String password, HttpServletRequest request, HttpServletResponse response){
        */
/**
         * 使用shiro编写认证操作
         *//*

        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        //执行登录方法
        try {
            subject.login(token);
            response.setStatus(200);
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败：用户名不存在
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败：密码错误
        }
        System.out.println("ok");
        return true;
    }
}
*/
