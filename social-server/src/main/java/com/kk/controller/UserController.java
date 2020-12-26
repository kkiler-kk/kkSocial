package com.kk.controller;

import com.alibaba.fastjson.JSON;
import com.kk.bean.User;
import com.kk.service.UserService;
import com.kk.util.LinkData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String login(String email, String password){
        if(Objects.equals(email, "") || Objects.equals(password, "")) throw new NullPointerException("email password is empty");
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        User user = userService.login(email, password);
        return JSON.toJSONString(user);
    }
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(String email, String password, String name, Integer gender, @RequestParam("file") MultipartFile file, Integer code){
        if(Objects.equals(email, "") || Objects.equals(password, "") || Objects.equals(name, "")){
            throw new NullPointerException("email and password and name is empty");
        }
        String url = LinkData.upload(file, email);
        if(url == "") return "";
        User user = new User(email,password,name,gender,url);
        return "{ \"code\": "+userService.register(user,code)+"}";
    }
    @RequestMapping(value = "/existEmail.do", method = RequestMethod.GET)
    @ResponseBody
    public String existEmail(String email){
        return "{ \"email\" : "+email+",\"flag\":" + userService.existEmail(email) + "}";
    }
    @RequestMapping(value = "/sendEmail.do", method = RequestMethod.GET)
    public void sendEmail(String email){
        userService.sendEmail(email);
    }
}
