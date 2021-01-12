package com.kk.controller;

import static com.kk.util.ErrorCode.*;

import com.kk.bean.ResponseResult;
import com.kk.bean.User;
import com.kk.service.UserService;
import com.kk.util.FileUtil;
import com.kk.util.StrUtil;
import com.kk.util.ToolUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Api(value = "用户Controller", tags = "用户接口")
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
    @ApiOperation("请求用户基本信息")
    @PostMapping(value = "get-user")
    public ResponseResult<User> getUser(HttpServletRequest request){
        User user = userService.getUser(1);
        return new ResponseResult<>(user);
    }
    @ApiOperation("根据Name查询用户基本信息并返回动态")
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public ResponseResult<User> getUserByName(@ApiParam("查询的用户名") @PathVariable String name){
        if(StrUtil.isEmpty(name)){
            return new ResponseResult<>(ILLEGAL_NULL);
        }
        User userByName = userService.getUserByName(name);
        if(userByName == null) return new ResponseResult<>(NOT_FOUND);
        return new ResponseResult<>(userByName);
    }
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String"),
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult<String> login(@RequestParam("email") String email, @RequestParam("password") String password){
        if(StrUtil.isEmpty(email,password)){
            return new ResponseResult<String>(ILLEGAL_NULL);
        }
        //if(!StrUtil.isValidEmail(email)) throw new SecurityException("email no standard")
        String token = userService.login(email, password);
        if(token == null) return new ResponseResult<>(ILLEGAL_PARAMETER);
        return new ResponseResult<>(token);
    }
    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult<String> register(@ModelAttribute User user, @RequestParam("file") MultipartFile file, String code){

        String email = user.getEmail(), password = user.getPassword(), name = user.getName();
        if(StrUtil.isEmpty(email,password, name)){
            return new ResponseResult(ILLEGAL_NULL);
        }
        String url = "";
        if(file != null ) {
            url = FileUtil.uploadFile(file, email);
        }
        user.setUrl(url);
        int register = userService.register(user, code);
        return register > 0 ? new ResponseResult<>("OK"): new ResponseResult<>(register);
    }

    @ApiOperation("验证邮箱是否存在")
    @RequestMapping(value = "/exist-email", method = RequestMethod.GET)
    public ResponseResult existEmail(@ApiParam("需要验证的邮箱")@RequestParam("email") String email){
        if(StrUtil.isEmpty(email)) return new ResponseResult(ILLEGAL_NULL, "邮箱为NUll");
        return userService.existEmail(email) ? new ResponseResult("邮箱可用") : new ResponseResult(EXIST_CODE);
    }

    @ApiOperation("验证Name是否存在")
    @RequestMapping(value = "/exist-name/{name}",method = RequestMethod.GET)
    public ResponseResult<String> existName(@ApiParam("需要验证的name")@PathVariable String name){
        if(StrUtil.isEmpty(name)){
            return new ResponseResult<>(ILLEGAL_NULL);
        }
        User userByName = userService.existName(name);
        return userByName == null ? new ResponseResult<>("name可用") : new ResponseResult<>(EXIST_CODE);
    }

    @ApiOperation("发送邮件")
    @RequestMapping(value = "/send-email", method = RequestMethod.GET)
    public ResponseResult sendEmail(@RequestParam(value = "email") String email){
        if(StrUtil.isEmpty(email)) return new ResponseResult(ILLEGAL_NULL);
        userService.sendEmail(email);
        return new ResponseResult("发送成功");
    }
}
