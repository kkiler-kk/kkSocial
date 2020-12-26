package com.kk.controller;

import com.kk.bean.Dto;
import com.kk.bean.User;
import com.kk.service.UserService;
import com.kk.util.ErrorCode;
import com.kk.util.LinkData;
import com.kk.util.StrUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    public UserController(){
        userService = UserService.getInstance();
    }
    private UserService userService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Dto<String> login(@RequestParam(value = "email")String email,@RequestParam(value = "password") String password){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new Dto<String>(ErrorCode.ILLEGAL_PARAMETER, "邮箱或者密码为空");
        }
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        Dto<String> result = userService.login(email, password);
        return result;
    }
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public Dto register(String email, String password, String name, Integer gender, @RequestParam("file") MultipartFile file, Integer code){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password) || StrUtil.isEmpty(name)){
            return new Dto(ErrorCode.ILLEGAL_PARAMETER ,"参数为空");
        }
        String url = LinkData.upload(file, email);
        if(url == "") return new Dto<>(ErrorCode.INSERT_FAIL, "code is error");
        User user = new User(email,password,name,gender,url);
        return userService.register(user, code);
    }
    @RequestMapping(value = "/existEmail.do", method = RequestMethod.GET)
    @ResponseBody
    public Dto existEmail(String email){
        if(StrUtil.isEmpty(email)) return new Dto(ErrorCode.ILLEGAL_PARAMETER, "邮箱为NUll");
        return userService.existEmail(email);
    }
    @RequestMapping(value = "/sendEmail.do", method = RequestMethod.GET)
    public void sendEmail(String email){
        if(StrUtil.isEmpty(email)) return;
        userService.sendEmail(email);
    }
}
