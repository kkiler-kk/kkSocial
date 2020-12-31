package com.kk.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kk.bean.News;
import com.kk.bean.ResponseResult;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @GetMapping("/hello")
    public ResponseResult<List<News>> hello(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        List<News> newsAndUserById = newsDao.getNewsAndUserById(1);
        return new ResponseResult<>(newsAndUserById);
    }
}
