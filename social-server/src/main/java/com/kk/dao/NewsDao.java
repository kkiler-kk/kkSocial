package com.kk.dao;

import com.kk.bean.News;

import java.util.List;

public interface NewsDao {
    List<News> getSelectRandom();

    List<News> getNewsAndUserById(Integer id);
    List<News> getNewsByTag(String tag);
    List<News> getNewsAndOwn(Integer id);

    News getNewsById(Integer id);

    List<String> getTopTag();
    int countNews(Integer user_id);
    int addNews(News news);
}
