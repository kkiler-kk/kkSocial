package org.kk.config.interceptor;

import com.alibaba.fastjson.JSON;
import org.kk.bean.ResponseResult;
import org.kk.util.ErrorCode;
import org.kk.util.JwtTokenUtil;
import org.kk.util.StrUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtInterceptor implements  HandlerInterceptor  {

    @Override //调用接口前调用 如果返回false就不执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String authHeader = request.getHeader("Authorization");
        try {
            response.setCharacterEncoding("UTF-8");
            if (StrUtil.isEmpty(authHeader)) {
                String s = JSON.toJSONString(new ResponseResult<>(ErrorCode.NOT_LOGIN));
                response.getWriter().append(s);
                return false;
            }
            boolean claims = JwtTokenUtil.isExpiration(authHeader);
            if(claims) throw new Exception();
            String userId = JwtTokenUtil.getUserId(authHeader);
            request.setAttribute("id", userId);
        } catch (Exception e) {
            String s = JSON.toJSONString(new ResponseResult<>(ErrorCode.TOKEN_PAST));
            try {
                response.getWriter().append(s);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
        return true;
    }
    @Override //控制器走完 执行此方法
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }


    @Override //前端渲染完 走此方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(response.getStatus());

    }
}
