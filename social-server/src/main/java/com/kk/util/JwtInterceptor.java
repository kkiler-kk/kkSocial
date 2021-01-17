package com.kk.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSON;
import com.kk.bean.ResponseResult;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements  HandlerInterceptor  {

    @Override //调用接口前调用 如果返回false就不执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String authHeader = request.getHeader("Authorization");
        if(StrUtil.isEmpty(authHeader)){
            response.setCharacterEncoding("UTF-8");
            try {
                String s = JSON.toJSONString(new ResponseResult<>(ErrorCode.NOT_LOGIN));
                response.getWriter().append(s);
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }
        Claims claims = JwtTokenUtil.checkJWT(authHeader);
        if (claims == null) return false;
        String userId = JwtTokenUtil.getUserId(authHeader);
        request.setAttribute("id", userId);
        return true;
    }
    @Override //控制器走完 执行此方法
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }


    @Override //前端渲染完 走此方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(response.getStatus());
        System.out.println("请求结束了");
    }
}
