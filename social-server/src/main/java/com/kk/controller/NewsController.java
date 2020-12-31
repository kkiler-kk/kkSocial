package com.kk.controller;

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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping(value = "/get-top.do")
    @ResponseBody
    @JsonIgnoreProperties
    public ResponseResult<PageInfo> getTop(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return null;
    }
}
