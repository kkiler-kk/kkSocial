package com.kk.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.PageRequest;
import com.kk.bean.ResponseResult;
import com.kk.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "动态Controller")
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @ApiOperation(value = "返回最热动态")
    @GetMapping(value = "/get-top/{pageNum}/{pageSize}")
    public ResponseResult<PageInfo<News>> getTop(@ApiParam(value = "起点") @PathVariable String pageNum, @ApiParam(value = "终点") @PathVariable String pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageInfo<News> selectRandom = newsService.getSelectRandom(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
        return new ResponseResult<>(selectRandom);
    }
    @ApiOperation(value = "返回好友动态")
    @GetMapping(value = "get-user")
    public ResponseResult<List<News>> getList(HttpServletRequest request){
        Integer userId = Integer.parseInt(request.getAttribute("userId").toString());
        List<News> friends = newsService.getFriends(userId);
        return new ResponseResult<>(friends);
    }
}
