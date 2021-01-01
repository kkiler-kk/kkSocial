package com.kk.controller;

import static com.kk.util.ErrorCode.*;

import com.alibaba.fastjson.JSON;
import com.kk.bean.ResponseResult;
import com.kk.bean.User;
import com.kk.service.NewsService;
import com.kk.service.UserService;
import com.kk.util.LinkData;
import com.kk.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api("用户Controller")
@RestController
@RequestMapping(value = "/user")
@Component
public class UserController {
//    @PathVariable：自动将rest请求匹配到同名参数上
//
//    @ModelAttribute：自动将请求的form表单参数 组装成对象
//
//    @RequestBody:自动将请求的json参数 组装成对象
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;

    @ApiOperation("根据Name查询用户基本信息并返回动态")
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public ResponseResult<User> getUserByName(@ApiParam("查询的用户名") @PathVariable String name){
        if(StrUtil.isEmpty(name)){
            return new ResponseResult<>(ILLEGAL_NULL, "name为null");
        }
        User userByName = userService.getUserByName(name);
        if(userByName == null) return new ResponseResult<>(NOT_FOUND, "找不到用户");
        return new ResponseResult<>(userByName);
    }
    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult<String> login(@ApiParam("邮箱")@RequestParam("email") String email, @ApiParam("密码")@RequestParam("password") String password){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new ResponseResult<String>(ILLEGAL_NULL, "邮箱或者密码为空");
        }
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        String token = userService.login(email, password);
        if(token == null) return new ResponseResult<>(ILLEGAL_PARAMETER, "请输入正确的用户名和密码");
        return new ResponseResult<>(token);
    }
    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult<String> register(@ModelAttribute User user, @RequestParam("file") MultipartFile file, String code){
        String email = user.getEmail(), password = user.getPassword(), name = user.getName();
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password) || StrUtil.isEmpty(name)){
            return new ResponseResult(ILLEGAL_NULL ,"参数为空");
        }
        String url = "";
        if(file != null ) {
            url = LinkData.upload(file, email);
        }
        user.setUrl(url);
        int register = userService.register(user, code);
        if(register  == -1) return new ResponseResult(INSERT_FAIL, "验证码已经过期!!!!");
        if(register  == -2) return new ResponseResult(INSERT_FAIL, "验证码错误!!!!");
        return register  > 0? new ResponseResult("OK") : new ResponseResult(INSERT_FAIL, "注册失败");
    }
    @ApiOperation("验证邮箱是否存在")
    @RequestMapping(value = "/existEmail", method = RequestMethod.GET)
    public ResponseResult existEmail(@ApiParam("需要验证的邮箱")@RequestParam("email") String email){
        if(StrUtil.isEmpty(email)) return new ResponseResult(ILLEGAL_NULL, "邮箱为NUll");
        return userService.existEmail(email) ? new ResponseResult("邮箱可用") : new ResponseResult(QUERY_FAIL, "邮箱已经存在");
    }
    @ApiOperation("验证Name是否存在")
    @RequestMapping(value = "/existName/{name}",method = RequestMethod.GET)
    public ResponseResult<String> existName(@ApiParam("需要验证的name")@PathVariable String name){
        if(StrUtil.isEmpty(name)){
            return new ResponseResult<>(ILLEGAL_NULL, "name为null");
        }
        User userByName = userService.getUserByName(name);
        return userByName == null ? new ResponseResult<>("name可用") : new ResponseResult<>(ILLEGAL_PARAMETER, "name已存在!");
    }
    @ApiOperation("发送邮件")
    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public ResponseResult sendEmail(@RequestParam(value = "email") String email){
        if(StrUtil.isEmpty(email)) return new ResponseResult(ILLEGAL_NULL, "参数为空");
        userService.sendEmail(email);
        return new ResponseResult("发送成功");
    }
    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePwd/", method = RequestMethod.POST)
    public ResponseResult<String> updatePwd(@RequestBody User user){
        String email = user.getEmail(), password = user.getPassword();
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new ResponseResult(UPDATE_FAIL, "参数为空");
        }
        int i = userService.updatePwd(email, password);
        if(i < 0){
            return new ResponseResult(UPDATE_FAIL, "修改密码失败");
        }
        return new ResponseResult<>("修改成功");
    }
}
