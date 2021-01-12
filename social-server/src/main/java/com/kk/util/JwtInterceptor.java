package com.kk.util;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String authHeader = request.getHeader("Authorization");
        if(StrUtil.isEmpty(authHeader)){
            return false;
        }
        Claim verify = TokenUtils.verify(authHeader);
        System.out.println(verify.asString());
        if (verify == null) return false;
        request.setAttribute("id",verify.asString());
        return true;
    }
}
