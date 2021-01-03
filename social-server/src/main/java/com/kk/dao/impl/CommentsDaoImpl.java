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
    public List<Comments> getByIdComment(Integer id, boolean flag) {
        CommentsDao aClass = createClass(CommentsDao.class);
        List<Comments> byIdComment = aClass.getByIdComment(id, flag);
        closeSession();
        return byIdComment;
    }

    @Override
    public int addComment(Comments comment) {
        CommentsDao aClass = createClass(CommentsDao.class);
        int i = aClass.addComment(comment);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int updateLike(Integer id, Integer like) {
        CommentsDao aClass = createClass(CommentsDao.class);
        int i = aClass.updateLike(id, like);
        commit();
        closeSession();
        return i;
    }
}
