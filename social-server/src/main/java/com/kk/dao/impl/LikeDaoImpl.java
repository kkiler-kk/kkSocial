package com.kk.dao.impl;

import com.kk.bean.Like;
import com.kk.dao.LikeDao;
import com.kk.util.LinkData;

import java.util.List;

public class LikeDaoImpl implements LikeDao {
    private static LikeDao likeDao;

    private LikeDaoImpl() {
    }

    public static LikeDao getInstance() {
        if (likeDao == null) {
            synchronized (NewsDaoImpl.class) {
                if (likeDao == null) {
                    likeDao = new LikeDaoImpl();
                }
            }
        }
        return likeDao;
    }
    @Override
    public List<Like> getUserById(Integer user_id) {
        LikeDao aClass = LinkData.createClass(LikeDao.class);
        List<Like> userById = aClass.getUserById(user_id);
        LinkData.closeSession();
        return userById;
    }

    @Override
    public int addLike(Like like) {
        LikeDao aClass = LinkData.createClass(LikeDao.class);
        int userById = aClass.addLike(like);
        LinkData.commit();
        LinkData.closeSession();
        return userById;
    }

    @Override
    public int deleteLike(Integer id) {
        LikeDao aClass = LinkData.createClass(LikeDao.class);
        int userById = aClass.deleteLike(id);
        LinkData.commit();
        LinkData.closeSession();
        return userById;
    }
}
