package com.kk.test;

import com.auth0.jwt.interfaces.Claim;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.*;
import com.kk.dao.CommentsDao;
import com.kk.dao.MessageDao;
import com.kk.dao.NewsDao;
import com.kk.dao.UserDao;
import com.kk.dao.impl.CommentsDaoImpl;
import com.kk.dao.impl.MsgDaoImpl;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.service.IMailService;
import com.kk.util.LinkData;
import com.kk.util.PageUtils;
import com.kk.util.TokenUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RandomTest {
    @Autowired
    IMailService iMailService;
    @Test
    public void testImail(){
        iMailService.sendSimpleMail("3258261356@qq.com","kk","test");
    }
    @Test
    public void testUser(){
        UserDao userDao = UserDaoImpl.getInstance();
        PageHelper.startPage(0,1);
        User kk = userDao.getUserByName("KK");
        PageInfo<News> pageInfo = new PageInfo<>(kk.getNewsList());
        System.out.println(kk);
        pageInfo.getList().forEach(System.out::println);
    }
    @Test
    public void testNews(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        List<News> selectRandom = newsDao.getSelectRandom();
        selectRandom.forEach(System.out::println);
    }
    @Test
    public void testComment(){
        CommentsDao commentsDao = CommentsDaoImpl.getInstance();
        List<Comments> byIdComment = commentsDao.getByIdComment(3);
        byIdComment.forEach(System.out::println);
    }
    @Test
    public void testToken(){
        String token = TokenUtils.token("2");
        System.out.println(token);
        Claim verify = TokenUtils.verify(token);
        System.out.println(verify.asString());
    }
    @Test
    public void testMessage(){
        MessageDao instance = MsgDaoImpl.getInstance();
        int i = instance.deleteById(2);
        System.out.println(i);
    }
}















