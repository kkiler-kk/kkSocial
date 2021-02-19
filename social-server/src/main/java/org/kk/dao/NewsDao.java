package org.kk.dao;

import org.kk.bean.News;
import org.kk.bean.Status;

import java.util.List;

public interface NewsDao  extends GiveParent{
    List<News> getSelectRandom();

    List<News> getNewsAndUserById(Integer id);

    List<News> getNewsByTag(String tag);

    List<News> getNewsAndOwn(Integer id);

    News getNewsById(Integer id);

    List<String> getTopTag();
    List<String> getTopSearch();
    String getSearch();
}
