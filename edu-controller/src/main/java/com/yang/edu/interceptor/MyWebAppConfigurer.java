package com.yang.edu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : MrYang
 * @Description : 设置过滤
 * @Date : 2019-10-23
 **/
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截的路径
        //String [] interceptor = {"/user/**","/home","/teacher/**"};
        //路径白名单
        String [] exInterceptor = {"","/","/static/**","/welcome","/login/**","/logout","/index","/addBannerimg",
                "/testCode","/head","/foot","/news","/news/detail/**","/map","/login/getCheckNum/**"};

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(exInterceptor);
    }
}
