package com.kk.dao.impl;

import com.kk.bean.News;
import com.kk.dao.NewsDao;
import static com.kk.util.LinkData.*;

import java.util.List;

public class NewsDaoImpl implements NewsDao {
    private static NewsDao newsDao;

    private NewsDaoImpl() {
    }

    public static NewsDao getInstance() {
        if (newsDao == null) {
            synchronized (NewsDaoImpl.class) {
                if (newsDao == null) {
                    newsDao = new NewsDaoImpl();
                }
            }
        }
        return newsDao;
    }
    @Override
    public List<News> getSelectRandom() {
        NewsDaoImpl aClass = createClass(NewsDaoImpl.class);
        List<News> list = aClass.getSelectRandom();
        closeSession();
        return list;
    }

    @Override
    public List<News> getNewsAndUserById(Integer id) {
        NewsDaoImpl aClass = createClass(NewsDaoImpl.class);
        List<News> list = aClass.getNewsAndUserById(id);
        closeSession();
        return list;
    }

    @Override
    public List<News> getNewsAndOwn(Integer id) {
        NewsDaoImpl aClass = createClass(NewsDaoImpl.class);
        List<News> list = aClass.getNewsAndOwn(id);
        closeSession();
        return list;
    }

    @Override
    public News getNewsById(Integer id) {
        NewsDaoImpl aClass = createClass(NewsDaoImpl.class);
        News news = aClass.getNewsById(id);
        closeSession();
        return news;
    }
}
