package com.yang.edu.util.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : MrYang
 * @Description : 设置过滤
 * @Date : 2019-10-23
 **/
@SpringBootConfiguration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    /*@Autowired
    private LoginInterceptor loginInterceptor;*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
        //excludePathPatterns()  过滤的请求url
    }
}
