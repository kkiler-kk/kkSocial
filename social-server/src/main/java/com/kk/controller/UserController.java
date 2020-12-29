package com.kk.controller;

import static com.kk.util.ErrorCode.*;
import com.kk.bean.Dto;
import com.kk.bean.News;
import com.kk.bean.User;
import com.kk.service.NewsService;
import com.kk.service.UserService;
import com.kk.util.LinkData;
import com.kk.util.StrUtil;
import com.kk.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
@Component
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public Dto<String> login(@RequestParam(value = "email")String email,@RequestParam(value = "password") String password){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new Dto<String>(ILLEGAL_NULL, "邮箱或者密码为空");
        }
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        String login = userService.login(email, password);
        return new Dto<>(login);
    }
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public Dto<String> register(String email, String password, String name, Integer gender, @RequestParam("file") MultipartFile file, String code){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password) || StrUtil.isEmpty(name)){
            return new Dto(ILLEGAL_NULL ,"参数为空");
        }
        String url = "";
        if(file != null ) {
            url = LinkData.upload(file, email);
        }
        User user = new User(email,password,name,gender,url);
        int register = userService.register(user, code);
        if(register  == -1) return new Dto(INSERT_FAIL, "验证码已经过期!!!!");
        if(register  == -2) return new Dto(INSERT_FAIL, "验证码错误!!!!");
        String token = TokenUtils.token(email, password);
        return register  > 0? new Dto(token) : new Dto(INSERT_FAIL, "注册失败");
    }
    @RequestMapping(value = "/existEmail.do", method = RequestMethod.GET)
    public Dto existEmail(String email){
        if(StrUtil.isEmpty(email)) return new Dto(ILLEGAL_NULL, "邮箱为NUll");
        return userService.existEmail(email) ? new Dto("邮箱可用") : new Dto(QUERY_FAIL, "邮箱已经存在");
    }

    @RequestMapping(value = "/sendEmail.do", method = RequestMethod.GET)
    public Dto sendEmail(@RequestParam("email") String email){
        if(StrUtil.isEmpty(email)) return new Dto(ILLEGAL_NULL, "参数为空");
        userService.sendEmail(email);
        return new Dto("发送成功");
    }
    @RequestMapping(value = "/updatePwd.do", method = RequestMethod.POST)
    public Dto<String> updatePwd(String email, String password){
        if(StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return new Dto(UPDATE_FAIL, "参数为空");
        }
        int i = userService.updatePwd(email, password);
        if(i < 0){
            return new Dto(UPDATE_FAIL, "修改密码失败");
        }
        return new Dto<>("修改成功");
    }
    @RequestMapping(value = "/existUser.do")
    public Dto<List<News>> existUser(String token){
        Dto<List<News>> result = null;
        List<News> list = null;
        if (StrUtil.isEmpty(token)){
            list = newsService.getSelectRandom();
            result = new Dto<>(ILLEGAL_NULL, "token为空");
            result.setData(list);
            return result;
        }
        boolean verify = userService.existToken(token);
        if (verify){
            //暂时未作处理 此处应该返回好友动态
        }
        result = new Dto<>(TOKEN_PAST, "token已过期,请先登录!");
        list = newsService.getSelectRandom();
        result.setData(list);
        return result;
    }
}
