package org.kk.controller.privates;

import org.kk.bean.ResponseResult;
import org.kk.bean.User;
import org.kk.service.UserService;
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
        Integer i = Integer.parseInt(String.valueOf(userId));
        User user = userService.getUser(i);
        return new ResponseResult<>(user);
    }
    @ApiOperation("查询用户是否关注过博主")
    @ApiImplicitParam(name = "name",value = "博主的Name")
    @GetMapping("isAttention/{name}")
    public ResponseResult<Boolean> isAttention(HttpServletRequest request, @PathVariable String name){
        Object userId = request.getAttribute("id");
        Integer i = Integer.parseInt(String.valueOf(userId));
        boolean attention = userService.isAttention(i, name);
        return new ResponseResult<>(attention);
    }
}
