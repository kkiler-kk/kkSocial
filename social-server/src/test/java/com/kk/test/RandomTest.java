package com.kk.test;

import com.kk.bean.*;
import com.kk.dao.*;
import com.kk.service.IMailService;
import com.kk.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RandomTest {
    @Autowired
    IMailService iMailService;
    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    NewsDao newsDao;
    @Test
    public void testUser(){
        User byData = userDao.getUserByName("KK");
        System.out.println(byData.getUserInfo());
        System.out.println(byData.getUserInfo().getNewsList());
    }
    @Test
    public void testUserInfo(){
        UserInfo userHome = userInfoDao.getUserHome(1);
        System.out.println(userHome);
        System.out.println(userHome.getNewsList());
    }
    @Test
    public void testNews(){
        List<News> newsAndOwn = newsDao.getNewsAndOwn(2);
    }
}
