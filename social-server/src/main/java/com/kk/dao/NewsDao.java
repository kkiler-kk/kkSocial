package com.kk.dao;

import com.kk.bean.News;

import java.util.List;

public interface NewsDao {
    List<News> getSelectRandom();

    List<News> getNewsAndUserById(Integer id);

    News getNewsById(Integer id);

}
