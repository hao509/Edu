package com.yang.edu.util.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : MrYang
 * @Description : 一些功能未登录不能访问
 * @Date : 2019-10-23
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获得请求路径的uri
        /*String uri = request.getRequestURI();
        System.out.println(uri);*/
        // 判断路径是登出还是登录验证，是这两者之一的话执行Controller中定义的方法
        /*if(uri.endsWith("login")||uri.endsWith("")) {
            response.setStatus(200);
            return true;
        }*/

        Object user = request.getSession().getAttribute("user_session_key");
        if (user == null) {
            //如果用户没有登录，则返回401状态码
            response.setStatus(401);
            return false;
        }else{
            response.setStatus(200);
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
