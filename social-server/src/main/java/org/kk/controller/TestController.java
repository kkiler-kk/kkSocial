package org.kk.controller;
import org.kk.util.JwtTokenUtil;
import org.kk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.UnsupportedEncodingException;

/* 类注解 */
@Api(value = "测试类",tags = "测试接口")
@RestController
public class TestController {
    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="/hello")
    public String hello(@RequestParam("id") String id) throws UnsupportedEncodingException {
        String token = JwtTokenUtil.createToken(id);

        return token;
    }
}