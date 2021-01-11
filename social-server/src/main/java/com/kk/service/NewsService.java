package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.PageRequest;
import com.kk.bean.PageResult;
import com.kk.dao.NewsDao;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.util.PageUtils;
import com.kk.util.StrUtil;
import com.kk.util.ToolUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    private NewsDao newsDao;
    private NewsService(){
        newsDao = NewsDaoImpl.getInstance();
    }
    public PageResult getSelectRandom(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsDao.getSelectRandom();
        ToolUtil.setList(list);
        return PageUtils.getPageResult(new PageInfo<>(list));
    }

    /**
     * 好友动态
     * @param id 用户ID
     * @return
     */
    public PageResult getFriends(Integer id, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsAndUserById = newsDao.getNewsAndUserById(id);
        return PageUtils.getPageResult(new PageInfo<>(newsAndUserById));
    }
    public Integer add(Integer id, String picture, String content_text, String tag){
        News news = new News(id,picture,content_text,tag);
        int i = newsDao.addNews(news);
        return i;
    }
    public Integer add(News news){
        System.out.println(news);
        int i = newsDao.addNews(news);
        return i;
    }
}
