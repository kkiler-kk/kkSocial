package com.kk.dao;

import com.kk.bean.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);


    List<User> getUserAndFriendsById(Integer id);
}
