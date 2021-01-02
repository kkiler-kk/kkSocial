package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.PageRequest;
import com.kk.bean.PageResult;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsService {
    private NewsDao newsDao;
    private NewsService(){
        newsDao = NewsDaoImpl.getInstance();
    }
    public PageResult getSelectRandom(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsDao.getSelectRandom();
        return PageUtils.getPageResult(new PageInfo<>(list));
    }

    /**
     * 好友动态
     * @param id 用户ID
     * @return
     */
    public PageResult getFriends(Integer id, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsAndUserById = newsDao.getNewsAndUserById(id);
        return PageUtils.getPageResult(new PageInfo<>(newsAndUserById));
    }
}
