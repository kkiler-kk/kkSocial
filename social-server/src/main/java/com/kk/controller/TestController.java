package com.kk.controller;
import com.kk.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/* 类注解 */
@Api(value = "测试类",tags = "测试接口")
@RestController
public class TestController {
    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="/hello")
    public String hello(@RequestParam("id") String id) {
        String token = JwtTokenUtil.createToken(id,"普通用户");
        return token;
    }
}