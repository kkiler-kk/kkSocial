package com.kk.config;

import com.kk.util.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //添加拦截器
        String[] strings = {"/user/login","/user/sendEmail/*","/user/*","/user/register/*","/user/existEmail","/upload/*","/hello","/news/get-top"};
        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns(strings);//放某些路由不需要验证
    }
}
