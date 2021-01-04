package com.kk.controller;

import com.kk.bean.PageRequest;
import com.kk.bean.PageResult;
import com.kk.bean.ResponseResult;
import com.kk.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "动态Controller",tags = "动态接口")
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @ApiOperation(value = "返回最热动态")
    @GetMapping(value = "/get-top")
    public ResponseResult<PageResult> getTop(@ApiParam("分页对象")@RequestBody PageRequest pageRequest){
        PageResult selectRandom = newsService.getSelectRandom(pageRequest);
        return new ResponseResult<>(selectRandom);
    }
    @ApiOperation(value = "返回好友动态")
    @GetMapping(value = "get-user")
    public ResponseResult<PageResult> getList(HttpServletRequest request, @ApiParam("分页对象")@RequestBody PageRequest pageRequest){
        Integer userId = Integer.parseInt(request.getAttribute("userId").toString());
        PageResult friends = newsService.getFriends(userId, pageRequest);
        return new ResponseResult<>(friends);
    }

}
