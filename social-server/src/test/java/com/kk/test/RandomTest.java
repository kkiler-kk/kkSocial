package com.kk.test;

import com.kk.bean.*;
import com.kk.dao.*;
import com.kk.dao.impl.*;
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
    @Test
    public void testImail(){
        iMailService.sendSimpleMail(
                "kk996icu@163.com","kk","test");
    }
    @Test
    public void testUser(){
        UserDao userDao = UserDaoImpl.getInstance();
        User userId = userDao.getUserId(1);
        System.out.println(userId.getCountNews());
    }
    @Test
    public void testNews(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        int count = newsDao.count(new Status<>(1));
        System.out.println("count = " + count);
    }
    @Test
    public void testComment(){
        CommentsDao commentsDao = CommentsDaoImpl.getInstance();
        Status status = new Status(1,true);
        int i = commentsDao.updateLike(status);
        System.out.println(i);
    }
    @Test
    public void testToken(){
        String id = JwtTokenUtil.createToken("2", "123");
        boolean expiration = JwtTokenUtil.isExpiration(id);
        System.out.println(expiration);
    }
    @Test
    public void testMessage(){
        MessageDao instance = MsgDaoImpl.getInstance();
    }
    @Test
    public void testLike(){
        LikeDao instance = LikeDaoImpl.getInstance();
        List<Like> userById = instance.getUserById(4);
        System.out.println("userById = " + userById);
    }
}















