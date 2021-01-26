package com.kk.controller.privates;

import com.kk.bean.ResponseResult;
import com.kk.service.UserInfoService;
import com.kk.util.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author kk
 * @Date 2021/1/25
 */

@Api(value = "用户信息private Controller", tags = "用户信息接口")
@RestController(value = "UserInfoPrivate")
@RequestMapping(value = "/private")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("添加关注")
    @PostMapping(value = "add-attention")
    public ResponseResult<String> addAttention(HttpServletRequest request){
        Object o = request.getAttribute("id");
        int id = Integer.parseInt(String.valueOf(o));
        Integer i = userInfoService.addAttention(id);
        return new ResponseResult<>(i);
    }
}
