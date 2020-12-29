package com.kk.service;

import com.kk.bean.News;
import com.kk.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public List<News> getSelectRandom(){
        return newsDao.getSelectRandom();
    }
}
