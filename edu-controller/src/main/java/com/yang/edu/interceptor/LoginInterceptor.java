package com.yang.edu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

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
        /*if(uri.endsWith("welcome")||uri.endsWith("")) {
            response.setStatus(200);
            return true;
        }*/

        Object user = request.getSession().getAttribute("user_session_key");
        if (user == null) {
            //如果用户没有登录，则返回到登录界面
            //response.sendRedirect("/edu/login");
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out;
            out = response.getWriter();
            out.print("<script>alert('请先登录');</script>");
            out.print("<script>location='/edu/login';</script>");
            //out.flush();//有了这个，下面的return就不会执行了
            return false;
        }else{
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
