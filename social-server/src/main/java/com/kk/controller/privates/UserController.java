package com.kk.controller.privates;

import com.kk.bean.ResponseResult;
import com.kk.bean.User;
import com.kk.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "用户private Controller", tags = "用户接口")
@RestController(value = "UserPrivate")
@RequestMapping(value = "/private")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("请求用户基本信息")
    @PostMapping(value = "get-user")
    public ResponseResult<User> getUser(HttpServletRequest request){
        Object userId = request.getAttribute("id");
        int i = Integer.parseInt(String.valueOf(userId));
        User user = userService.getUser(i);
        return new ResponseResult<>(user);
    }
}
