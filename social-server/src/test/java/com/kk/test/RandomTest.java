package com.kk.test;

import com.auth0.jwt.interfaces.Claim;
import com.kk.bean.Comments;
import com.kk.bean.News;
import com.kk.bean.User;
import com.kk.dao.CommentsDao;
import com.kk.dao.NewsDao;
import com.kk.dao.UserDao;
import com.kk.dao.impl.CommentsDaoImpl;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.service.IMailService;
import com.kk.util.TokenUtils;
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
        iMailService.sendSimpleMail("3258261356@qq.com","kk","test");
    }
    @Test
    public void testUser(){
        UserDao userDao = UserDaoImpl.getInstance();
        User kk = userDao.getUserByName("KK");
        System.out.println(kk);
        kk.getNewsList().forEach(System.out::println);
    }
    @Test
    public void testNews(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        List<News> newsAndUserById = newsDao.getNewsAndOwn(2);
        newsAndUserById.forEach(System.out::println);
    }
    @Test
    public void testComment(){
        CommentsDao commentsDao = new CommentsDaoImpl();
        List<Comments> byIdComment = commentsDao.getByIdComment(1);
        byIdComment.forEach(System.out::println);
    }
    @Test
    public void testToken(){
        String token = TokenUtils.token("2");
        System.out.println(token);
        Claim verify = TokenUtils.verify(token);
        System.out.println(verify.asString());
    }
}
