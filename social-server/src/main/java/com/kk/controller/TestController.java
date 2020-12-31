package com.kk.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kk.bean.News;
import com.kk.bean.ResponseResult;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @GetMapping("/hello")
    public List<News> hello(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        List<News> newsAndUserById = newsDao.getNewsAndUserById(1);
        newsAndUserById.forEach(System.out::println);
        return newsAndUserById;
    }
}
