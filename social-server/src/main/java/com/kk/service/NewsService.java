package com.kk.service;

import com.kk.bean.News;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsService {
    private NewsDao newsDao;
    private NewsService(){
        newsDao = NewsDaoImpl.getInstance();
    }
    public List<News> getSelectRandom(){
        return newsDao.getSelectRandom();
    }

    /**
     * 好友动态
     * @param id 用户ID
     * @return
     */
    public List<News> getFriends(Integer id){
        List<News> newsAndUserById = newsDao.getNewsAndUserById(id);
        return newsAndUserById;
    }
}
