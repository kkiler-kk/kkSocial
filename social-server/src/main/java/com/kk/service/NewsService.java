package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.PageRequest;
import com.kk.bean.PageResult;
import com.kk.bean.Status;
import com.kk.dao.NewsDao;
import com.kk.util.PageUtils;
import com.kk.util.RedisUtil;
import com.kk.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private NewsDao newsDao;

    public PageResult getSelectRandom(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsDao.getSelectRandom();
        ToolUtil.setList(list);
        PageResult pageResult = PageUtils.getPageResult(new PageInfo<>(list));
        return pageResult;
    }
    public PageResult getNewsByTag(String tag, PageRequest pageRequest){
        tag = "#" + tag + "#";
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsDao.getNewsByTag(tag);
        return PageUtils.getPageResult(new PageInfo<>(list));
    }
    public PageResult getFriends(Integer id, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsAndUserById = newsDao.getNewsAndUserById(id);
        return PageUtils.getPageResult(new PageInfo<>(newsAndUserById));
    }
    public List<String> getTopTag() {
        boolean flag = redisUtil.hashKey("top");
        if (!flag) {
            List<String> topTag = newsDao.getTopTag();
            redisUtil.set("top", topTag, 10800); //三小时刷新一下热搜
        }
        Object top = redisUtil.get("top");
        return (List<String>) top;
    }
    public Integer add(News news){
        System.out.println(news);
        int i = newsDao.add(new Status<News>(news));
        return i;
    }
}
