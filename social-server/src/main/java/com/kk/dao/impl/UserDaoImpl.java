package com.kk.dao.impl;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.util.LinkData;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

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
    public User getUserById(Integer id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            UserDao userDao = openSession.getMapper(UserDao.class);
            return userDao.getUserById(id);
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
    public User getUserByEmailAndPassword(String email, String password) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            UserDao userDao = openSession.getMapper(UserDao.class);
            return userDao.getUserByEmailAndPassword(email,password);
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
    public int countFriends(Integer id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            UserDao userDao = openSession.getMapper(UserDao.class);
            return userDao.countFriends(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
        return 0;
    }

    @Override
    public List<User> getUserAndFriendsById(Integer id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            UserDao userDao = openSession.getMapper(UserDao.class);
            return userDao.getUserAndFriendsById(id);
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
    public void addUser(User user) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            UserDao userDao = openSession.getMapper(UserDao.class);
            userDao.addUser(user);
            openSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession openSession = null;
        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            UserDao userDao = openSession.getMapper(UserDao.class);
            userDao.deleteUserById(id);
            openSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }


}
