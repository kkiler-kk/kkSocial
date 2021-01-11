package com.kk.test;

import com.auth0.jwt.interfaces.Claim;
import com.kk.bean.*;
import com.kk.dao.*;
import com.kk.dao.impl.*;
import com.kk.service.IMailService;
import com.kk.util.TokenUtils;
import com.kk.util.ToolUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



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
        System.out.println(userId);
    }
    @Test
    public void testNews(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
    }
    @Test
    public void testComment(){
        CommentsDao commentsDao = CommentsDaoImpl.getInstance();
    }
    @Test
    public void testToken(){
        String token = TokenUtils.token("1");
        System.out.println(token);
        Claim verify = TokenUtils.verify(token);
        String s = verify.asString();
        System.out.println(s);
    }
    @Test
    public void testMessage(){
        MessageDao instance = MsgDaoImpl.getInstance();
    }
    @Test
    public void testLike(){
        LikeDao instance = LikeDaoImpl.getInstance();
    }
}















