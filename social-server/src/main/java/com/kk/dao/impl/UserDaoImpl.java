package com.kk.dao.impl;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import java.util.List;

import static com.kk.util.LinkData.*;

public class UserDaoImpl implements UserDao {
    private static UserDao userDao;

    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }
    @Override
    public List<User> getUserAndFriendsById(Integer id) {
        UserDao aClass = createClass(UserDao.class);
        List<User> list = aClass.getUserAndFriendsById(id);
        closeSession();
        return list;
    }

    @Override
    public User getUserByName(String name) {
        UserDao aClass = createClass(UserDao.class);
        User user = aClass.getUserByName(name);
        closeSession();
        return user;
    }

    @Override
    public User getUserById(Integer id) {
        UserDao aClass = createClass(UserDao.class);
        User user = aClass.getUserById(id);
        closeSession();
        return user;
    }

    @Override
    public User getUserId(Integer id) {
        UserDao aClass = createClass(UserDao.class);
        User user = aClass.getUserId(id);
        closeSession();
        return user;
    }

    @Override
    public User getByData(Integer id) {
        UserDao aClass = createClass(UserDao.class);
        User user = aClass.getUserId(id);
        closeSession();
        return user;
    }

    @Override
    public Integer getUserEAndP(String email, String password) {
        UserDao aClass = createClass(UserDao.class);
        Integer count = aClass.getUserEAndP(email,password);
        closeSession();
        return count;
    }

    @Override
    public int countFriends(Integer id) {
        UserDao aClass = createClass(UserDao.class);
        int i = aClass.countFriends(id);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int updatePwd(String email, String password) {
        UserDao aClass = createClass(UserDao.class);
        int i = aClass.updatePwd(email, password);
        commit();
        closeSession();
        return i;
    }



    @Override
    public int addUser(User user) {
        UserDao aClass = createClass(UserDao.class);
        int i = aClass.addUser(user);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int addFriend(Integer user_id, Integer friend_id) {
        UserDao aClass = createClass(UserDao.class);
        int i = aClass.addFriend(user_id, friend_id);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int deleteFriend(Integer user_id, Integer friend_id) {
        UserDao aClass = createClass(UserDao.class);
        int i = aClass.deleteFriend(user_id, friend_id);
        commit();
        closeSession();
        return i;
    }

    @Override
    public int deleteUserById(Integer id) {
        UserDao aClass = createClass(UserDao.class);
        int i = aClass.deleteUserById(id);
        commit();
        closeSession();
        return i;
    }

}
