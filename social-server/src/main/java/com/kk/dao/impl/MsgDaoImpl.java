package com.kk.dao.impl;

import com.kk.bean.MessageType;
import com.kk.dao.MessageDao;
import com.kk.util.LinkData;

import java.util.List;

public class MsgDaoImpl implements MessageDao {
    private static MessageDao messageDao;

    private MsgDaoImpl() {
    }

    public static MessageDao getInstance() {
        if (messageDao == null) {
            synchronized (NewsDaoImpl.class) {
                if (messageDao == null) {
                    messageDao = new MsgDaoImpl();
                }
            }
        }
        return messageDao;
    }
    @Override
    public List<MessageType> getUserById(Integer id) {
        MessageDao aClass = LinkData.createClass(MessageDao.class);
        List<MessageType> userById = aClass.getUserById(id);
        LinkData.closeSession();
        return userById;
    }

    @Override
    public int addMsg(Integer user_id, Integer friend_id, String content) {
        MessageDao aClass = LinkData.createClass(MessageDao.class);
        int i = aClass.addMsg(user_id, friend_id, content);
        LinkData.commit();
        LinkData.closeSession();
        return i;
    }

    @Override
    public int deleteById(Integer id) {
        MessageDao aClass = LinkData.createClass(MessageDao.class);
        int i = aClass.deleteById(id);
        LinkData.commit();
        LinkData.closeSession();
        return i;
    }
}
