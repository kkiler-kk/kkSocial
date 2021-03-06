package org.kk.controller.publics;

import cn.hutool.core.date.DateUtil;
import org.kk.bean.ResponseResult;
import org.kk.bean.User;
import org.kk.service.UserService;
import org.kk.util.FileUtil;
import org.kk.util.StrUtil;
import io.swagger.annotations.*;
import org.kk.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@Api(value = "用户开放Controller", tags = "用户接口")
@RestController(value = "UserPublic")
@RequestMapping(value = "/public")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("根据Name查询用户基本信息并返回动态")
    @GetMapping(value = "/user/{name}")
    public ResponseResult<User> getUserByName(@ApiParam("查询的用户名") @PathVariable String name){
        if(StrUtil.isEmpty(name)){
            return new ResponseResult<>(ErrorCode.ILLEGAL_NULL);
        }
        User userByName = userService.getUserByName(name);
        if(userByName == null) return new ResponseResult<>(ErrorCode.NOT_FOUND);
        return new ResponseResult<>(userByName);
    }
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String"),
    })
    @PostMapping(value = "/login")
    public ResponseResult<String> login(@RequestParam("email") String email, @RequestParam("password") String password) throws UnsupportedEncodingException {
        if(StrUtil.isEmpty(email,password)){
            return new ResponseResult<String>(ErrorCode.ILLEGAL_NULL);
        }
        String token = userService.login(email, password);
        if(StrUtil.isEmpty(token)) return new ResponseResult<>(ErrorCode.USER_NOTHINGNESS);
        return new ResponseResult<>(token);
    }
    @ApiOperation("注册")
    @PostMapping(value = "/register")
    public ResponseResult<String> register(@ModelAttribute User user, @RequestParam("file") MultipartFile file, String code){
        String email = user.getEmail(), password = user.getPassword(), name = user.getName();
        if(StrUtil.isEmpty(email,password, name)){
            return new ResponseResult(ErrorCode.ILLEGAL_NULL);
        }
        String url = FileUtil.uploadFile(file, email);
        if(StrUtil.isEmpty(url)){
            if(user.getGender() == 1) url = "/upload/man.png";
            else url = "/upload/woman.png";
        }
        user.setUrl(url);
        user.setCreate_date(DateUtil.today());
        int register = userService.register(user, code);
        return new ResponseResult<>(register);
    }

    @ApiOperation("验证邮箱是否存在")
    @RequestMapping(value = "/exist-email", method = RequestMethod.GET)
    public ResponseResult existEmail(@ApiParam("需要验证的邮箱")@RequestParam("email") String email){
        if(StrUtil.isEmpty(email)) return new ResponseResult(ErrorCode.ILLEGAL_NULL, "邮箱为NUll");
        return userService.existEmail(email) ? new ResponseResult("邮箱可用") : new ResponseResult(ErrorCode.EXIST_CODE);
    }

    @ApiOperation("验证Name是否存在")
    @RequestMapping(value = "/exist-name/{name}",method = RequestMethod.GET)
    public ResponseResult<String> existName(@ApiParam("需要验证的name")@PathVariable String name){
        if(StrUtil.isEmpty(name)){
            return new ResponseResult<>(ErrorCode.ILLEGAL_NULL);
        }
        Integer result = userService.existName(name);
        return new ResponseResult<>(result);
    }

    @ApiOperation("发送邮件")
    @RequestMapping(value = "/send-email", method = RequestMethod.GET)
    public ResponseResult sendEmail(@RequestParam(value = "email") String email){
        if(StrUtil.isEmpty(email)) return new ResponseResult(ErrorCode.ILLEGAL_NULL);
        userService.sendEmail(email);
        return new ResponseResult("发送成功");
    }
}
