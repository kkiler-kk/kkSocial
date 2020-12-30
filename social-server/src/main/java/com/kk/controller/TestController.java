package com.kk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kk.bean.News;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler","parent"})
@RestController
public class TestController {
    @GetMapping("/hello")
    public List<News> hello(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        List<News> selectRandom = newsDao.getSelectRandom();
        return selectRandom;
    }
}
