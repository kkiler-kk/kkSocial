package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.PageRequest;
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
    public PageInfo<News> getSelectRandom(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsDao.getSelectRandom();
        return new PageInfo<News>(list);
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
