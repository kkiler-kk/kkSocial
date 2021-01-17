package com.kk.dao.impl;

import com.kk.bean.News;
import com.kk.bean.Status;
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
        NewsDao aClass = createClass(NewsDao.class);
        List<News> list = aClass.getSelectRandom();
        closeSession();
        return list;
    }

    @Override
    public List<News> getNewsAndUserById(Integer id) {
        NewsDao aClass = createClass(NewsDao.class);
        List<News> list = aClass.getNewsAndUserById(id);
        closeSession();
        return list;
    }

    @Override
    public List<News> getNewsByTag(String tag) {
        NewsDao aClass = createClass(NewsDao.class);
        List<News> list = aClass.getNewsByTag(tag);
        closeSession();
        return list;
    }

    @Override
    public List<News> getNewsAndOwn(Integer id) {
        NewsDao aClass = createClass(NewsDao.class);
        List<News> list = aClass.getNewsAndOwn(id);
        closeSession();
        return list;
    }

    @Override
    public News getNewsById(Integer id) {
        NewsDao aClass = createClass(NewsDao.class);
        News news = aClass.getNewsById(id);
        closeSession();
        return news;
    }

    @Override
    public List<String> getTopTag() {
        NewsDao aClass = createClass(NewsDao.class);
        List<String> list = aClass.getTopTag();
        closeSession();
        return list;
    }

    @Override
    public int updateLike(Status status) {
        NewsDao aClass = createClass(NewsDao.class);
        int i = aClass.updateLike(status);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int add(Status<?> status) {
        NewsDao newsDao = createClass(NewsDao.class);
        int i = newsDao.add(status);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int count(Status<?> status) {
        NewsDao aClass = createClass(NewsDao.class);
        int i = aClass.count(status);
        closeSession();
        return i;
    }
}
