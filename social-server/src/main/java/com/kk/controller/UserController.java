package com.kk.controller;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSON;
import com.kk.bean.User;
import com.kk.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(String email, String password){
        if(Objects.equals(email, "") || Objects.equals(password, "")) throw new NullPointerException("email password is empty");
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        User user = UserService.getInstance().login(email, password);
        return JSON.toJSONString(user);
    }
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(String email, String password, String name, Integer gender, @RequestParam("file") MultipartFile file){
        if(Objects.equals(email, "") || Objects.equals(password, "") || Objects.equals(name, "")){
            throw new NullPointerException("email and password and name is empty");
        }

        return "register";
    }
}
