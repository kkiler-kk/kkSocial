package com.kk.dao;

import com.kk.bean.News;

import java.util.List;

public interface NewsDao {
    List<News> getSelectRandom();

    News getNewsById(Integer id);
}
