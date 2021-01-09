package com.kk.controller;

import com.kk.bean.News;
import com.kk.bean.PageRequest;
import com.kk.bean.PageResult;
import com.kk.bean.ResponseResult;
import com.kk.service.NewsService;
import com.kk.util.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Api(value = "动态Controller",tags = "动态接口")
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @ApiOperation(value = "返回最热动态")
    @PostMapping(value = "/get-top")
    public ResponseResult<PageResult> getTop(@ApiParam("分页对象")@RequestBody PageRequest pageRequest){
        PageResult selectRandom = newsService.getSelectRandom(pageRequest);
        return new ResponseResult<>(selectRandom);
    }
    @ApiOperation(value = "返回好友动态")
    @PostMapping(value = "get-user")
    public ResponseResult<PageResult> getList(HttpServletRequest request, @ApiParam("分页对象")@RequestBody PageRequest pageRequest){
        String token = request.getHeader("token");
        System.out.println(token);
        PageResult friends = newsService.getFriends(1, pageRequest);
        return new ResponseResult<>(friends);
    }
    @ApiOperation(value = "新增动态")
    @PostMapping(value = "add", headers = "content-type=multipart/form-data")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(name = "content_text", value = "发布内容", dataType = "String"),
            @ApiImplicitParam(name = "files", value = "发布的图片",paramType = "formData",allowMultiple=true,required = true,dataType = "file"),
            @ApiImplicitParam(name = "tag",  value = "标签", dataType = "String")
    })
    public ResponseResult<String> addNews(News news, MultipartFile[] files){
        String s = FileUtil.uploadsFile(files, Integer.parseInt(CodeUtil.generateVerCode()));
        System.out.println(s);
        news.setPicture(s);
        Integer add = newsService.add(news);
        return add > 0 ? new ResponseResult<>("OK") : new ResponseResult<>(ErrorCode.INSERT_FAIL);
    }
//    @RequestParam("id") Integer id, @RequestParam("content_text") String content_text, @RequestParam("files")MultipartFile[] files,@RequestParam("tag")String tag
}
