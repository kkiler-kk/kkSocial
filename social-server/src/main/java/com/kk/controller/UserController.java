package com.kk.controller;

import com.kk.bean.Dto;
import com.kk.bean.User;
import com.kk.service.UserService;
import com.kk.util.ErrorCode;
import com.kk.util.LinkData;
import com.kk.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/user")
@Component
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Dto<String> login(@RequestParam(value = "email")String email,@RequestParam(value = "password") String password){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new Dto<String>(ErrorCode.ILLEGAL_NULL, "邮箱或者密码为空");
        }
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        String login = userService.login(email, password);
        return new Dto<>(login);
    }
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public Dto register(String email, String password, String name, Integer gender, @RequestParam("file") MultipartFile file, String code){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password) || StrUtil.isEmpty(name)){
            return new Dto(ErrorCode.ILLEGAL_NULL ,"参数为空");
        }
        String url = "";
        if(file != null ) {
            url = LinkData.upload(file, email);
        }
        User user = new User(email,password,name,gender,url);
        int register = userService.register(user, code);
        if(register  == -1) return new Dto(ErrorCode.INSERT_FAIL, "验证码已经过期!!!!");
        if(register  == -2) return new Dto(ErrorCode.INSERT_FAIL, "验证码错误!!!!");
        return register  > 0? new Dto("注册成功") : new Dto(ErrorCode.INSERT_FAIL, "注册失败");
    }
    @RequestMapping(value = "/existEmail.do", method = RequestMethod.GET)
    public Dto existEmail(String email){
        if(StrUtil.isEmpty(email)) return new Dto(ErrorCode.ILLEGAL_NULL, "邮箱为NUll");
        return userService.existEmail(email) ? new Dto("邮箱可用") : new Dto(ErrorCode.QUERY_FAIL, "邮箱已经存在");
    }

    @RequestMapping(value = "/sendEmail.do", method = RequestMethod.GET)
    public void sendEmail(@RequestParam("email") String email){
        if(StrUtil.isEmpty(email)) return;
        userService.sendEmail(email);
    }
    @RequestMapping(value = "/updatePwd.do", method = RequestMethod.POST)
    public Dto<String> updatePwd(String email, String password){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new Dto(ErrorCode.UPDATE_FAIL, "参数为空");
        }
        int i = userService.updatePwd(email, password);
        if(i < 0){
            return new Dto(ErrorCode.UPDATE_FAIL, "修改密码失败");
        }
        return new Dto<>("修改成功");
    }
}
