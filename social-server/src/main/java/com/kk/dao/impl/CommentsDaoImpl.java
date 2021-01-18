package com.kk.dao.impl;

import com.kk.bean.Comments;
import com.kk.bean.Status;
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
    public List<Comments> getByIdComment(Integer id, Boolean flag) {
        CommentsDao aClass = createClass(CommentsDao.class);
        List<Comments> byIdComment = aClass.getByIdComment(id, flag);
        closeSession();
        return byIdComment;
    }
    @Override
    public int updateLike(Status status) {
        CommentsDao aClass = createClass(CommentsDao.class);
        int i = aClass.updateLike(status);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int add(Status<?> status) {
        CommentsDao aClass = createClass(CommentsDao.class);
        int i = aClass.add(status);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int count(Status<?> status) {
        CommentsDao aClass = createClass(CommentsDao.class);
        int count = aClass.count(status);
        closeSession();
        return count;
    }
}
