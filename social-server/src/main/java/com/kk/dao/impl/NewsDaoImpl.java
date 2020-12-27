package com.kk.dao.impl;

import com.kk.bean.News;
import com.kk.dao.NewsDao;
import com.kk.util.LinkData;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class NewsDaoImpl implements NewsDao {

    @Override
    public List<News> getSelectRandom() {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            NewsDao newsDao = openSession.getMapper(NewsDao.class);
            return newsDao.getSelectRandom();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
        return null;
    }

    @Override
    public News getNewsById(Integer id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            NewsDao newsDao = openSession.getMapper(NewsDao.class);
            return newsDao.getNewsById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
        return null;
    }
}
