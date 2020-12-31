package com.kk.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kk.bean.News;
import com.kk.bean.ResponseResult;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler","parent"})
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
