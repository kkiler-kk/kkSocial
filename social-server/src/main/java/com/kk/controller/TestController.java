package com.kk.controller;
import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.TokenUtils;
import com.kk.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;

/* 类注解 */
@Api(value = "测试类",tags = "测试接口")
@RestController
public class TestController {
    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="/hello")
    public String hello(@RequestParam("id") String id) {
        String token = TokenUtils.token(id);
        return token;
    }
}