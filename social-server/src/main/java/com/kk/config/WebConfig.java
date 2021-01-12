package com.kk.config;

import com.kk.util.JwtInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.kk")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] strings = {"/user/login","/user/send-email","/user/*","/user/exist-name/*","/hello","/user/register/*","/user/exist-email","/news/get-top/**","/comment/news-id/*","/upload/**","/news-user/**","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"};
        InterceptorRegistration registration = registry.addInterceptor(new JwtInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(strings);//放某些路由不需要验证
    }
//    {"/**",};
}
