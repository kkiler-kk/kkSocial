package com.kk.util;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("Hello World");
        String authHeader = request.getHeader("Authorization");
        if(StrUtil.isEmpty(authHeader)){
            return false;
        }
        Claim verify = TokenUtils.verify(authHeader);
        if (verify == null) return false;
        request.setAttribute("userId",verify.asString());
        return true;
    }
}
