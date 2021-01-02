package com.kk.dao.impl;

import com.kk.bean.Comments;
import com.kk.dao.CommentsDao;
import static com.kk.util.LinkData.*;
import java.util.List;

public class CommentsDaoImpl implements CommentsDao {
    private static CommentsDao commentsDao;

    private CommentsDaoImpl() {
    }

    public static CommentsDao getInstance() {
        if (commentsDao == null) {
            synchronized (NewsDaoImpl.class) {
                if (commentsDao == null) {
                    commentsDao = new CommentsDaoImpl();
                }
            }
        }
        return commentsDao;
    }
    @Override
    public List<Comments> getByIdComment(Integer id) {
        CommentsDao aClass = createClass(CommentsDao.class);
        List<Comments> byIdComment = aClass.getByIdComment(id);
        closeSession();
        return byIdComment;
    }
//
//    SqlSessionFactory sqlSessionFactory;
//    SqlSession openSession = null;
//        try {
//        sqlSessionFactory = LinkData.getSessionFactory();
//        openSession = sqlSessionFactory.openSession();
//        CommentsDao commentsDao = openSession.getMapper(CommentsDao.class);
//        return commentsDao.getByIdComment(id);
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        if (openSession != null) {
//            openSession.close();
//        }
//    }
//        return new ArrayList<>();
}
