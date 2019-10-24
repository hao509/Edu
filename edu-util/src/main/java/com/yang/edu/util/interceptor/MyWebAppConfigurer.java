package com.yang.edu.util.interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author : MrYang
 * @Description : 设置过滤
 * @Date : 2019-10-23
 **/
@SpringBootConfiguration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Bean
    LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
        //excludePathPatterns()  过滤的请求url
    }
}
