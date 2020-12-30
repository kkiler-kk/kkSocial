package com.kk.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.Dto;
import com.kk.bean.News;
import com.kk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping(value = "/get-top.do")
    @ResponseBody
    public Dto<PageInfo> getTop(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<News> selectRandom = newsService.getSelectRandom();
        PageInfo<News> pageInfo = new PageInfo<>(selectRandom);
        return new Dto<>(pageInfo);
    }
}
