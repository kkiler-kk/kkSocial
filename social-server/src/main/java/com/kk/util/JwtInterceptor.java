package com.kk.util;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("Hello World");
        String authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        System.out.println(StrUtil.isEmpty(authHeader));
        if(StrUtil.isEmpty(authHeader)){
            return false;
        }
        Claim verify = TokenUtils.verify(authHeader);
        System.out.println(verify.asString());
        if (verify == null) return false;
        request.setAttribute("userId",verify.asString());
        System.out.println(request.getAttribute("userId"));
        return true;
    }
}
