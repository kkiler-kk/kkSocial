package com.kk.test;

import com.kk.DemoApplication;
import com.kk.bean.Comments;
import com.kk.bean.News;
import com.kk.dao.CommentsDao;
import com.kk.dao.NewsDao;
import com.kk.dao.UserDao;
import com.kk.dao.impl.CommentsDaoImpl;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.TokenUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)

public class RandomTest {
    @Test
    public void testUser(){
        UserDao instance = UserDaoImpl.getInstance();
        int i = instance.updatePwd("kk@kk.com", "123456");
        System.out.println(i);
    }
    @Test
    public void testNews(){
        NewsDao newsDao = new NewsDaoImpl();
        News newsById = newsDao.getNewsById(1);
        System.out.println(newsById);
    }
    @Test
    public void testComment(){
        CommentsDao commentsDao = new CommentsDaoImpl();
        List<Comments> byIdComment = commentsDao.getByIdComment(1);
        System.out.println(byIdComment.size());
    }
    @Test
    public void testToken(){
        String token = TokenUtils.token("kk@kk.com", "123456");
        boolean verify = TokenUtils.verify(token);
        System.out.println(verify);
    }
}
