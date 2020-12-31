package com.kk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.ResponseResult;
import com.kk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping(value = "/get-top")
    @JsonIgnoreProperties
    public ResponseResult<List<News>> getTop(){
        List<News> selectRandom = newsService.getSelectRandom();
        return new ResponseResult<>(selectRandom);
    }
    @GetMapping(value = "get-user")
    public ResponseResult<List<News>> getList(HttpServletRequest request){
        Integer userId = Integer.parseInt(request.getAttribute("userId").toString());
        List<News> friends = newsService.getFriends(userId);
        return new ResponseResult<>(friends);
    }
}
