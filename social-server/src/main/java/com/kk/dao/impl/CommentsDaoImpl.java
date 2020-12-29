package com.kk.dao.impl;

import com.kk.bean.Comments;
import com.kk.dao.CommentsDao;
import com.kk.util.LinkData;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CommentsDaoImpl implements CommentsDao {
    @Override
    public List<Comments> getByIdComment(Integer id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            CommentsDao commentsDao = openSession.getMapper(CommentsDao.class);
            return commentsDao.getByIdComment(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
        return new ArrayList<>();
    }
}
