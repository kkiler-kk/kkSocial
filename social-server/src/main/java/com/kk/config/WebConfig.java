package com.kk.config;

import com.kk.util.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] strings = {"/swagger-resources/**", "/webjars/**", "/v2/**","/swagger-ui.html/**","/public/**","/hello","/upload/**","/news/**"};
//        InterceptorRegistration registration = registry.addInterceptor(new JwtInterceptor());
//        registration.addPathPatterns("/**"); //拦截所有路由
//        registration.excludePathPatterns(strings);//放某些路由不需要验证,
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**").excludePathPatterns(strings);
    }
}
