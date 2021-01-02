package com.kk.dao;

import com.kk.bean.MessageType;

import java.util.List;

public interface MessageDao {
    List<MessageType> getUserById(Integer id);

    int addMsg(Integer user_id, Integer friend_id, String content);

    int deleteById(Integer id);
}
