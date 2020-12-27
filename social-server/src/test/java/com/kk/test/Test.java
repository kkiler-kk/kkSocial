package com.kk.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.User;
import com.kk.dao.NewsDao;
import com.kk.dao.UserDao;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test {
    @org.junit.Test
    public void test() {
        PageHelper.startPage(0,0);
        NewsDao newsDao = new NewsDaoImpl();
        List<News> selectRandom = newsDao.getSelectRandom();
        PageInfo<News> pageInfo = new PageInfo<>(selectRandom);

    }
    @org.junit.Test
    public void testUser(){
        UserDao instance = UserDaoImpl.getInstance();
        User userId = instance.getUserById(1);
        System.out.println(userId);
        System.out.println(userId.getFriendsList());
    }

}
