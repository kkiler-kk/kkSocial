package com.kk.dao;

import com.kk.bean.News;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface NewsDao {
    List<News> getSelectRandom();

    List<News> getNewsAndUserById(Integer id);

    News getNewsById(Integer id);

}
