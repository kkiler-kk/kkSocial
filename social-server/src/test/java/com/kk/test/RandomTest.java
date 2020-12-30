package com.kk.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.Comments;
import com.kk.bean.Dto;
import com.kk.bean.News;
import com.kk.bean.User;
import com.kk.dao.CommentsDao;
import com.kk.dao.NewsDao;
import com.kk.dao.UserDao;
import com.kk.dao.impl.CommentsDaoImpl;
import com.kk.dao.impl.NewsDaoImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.TokenUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RandomTest {
    @Test
    public void testUser(){
        UserDao instance = UserDaoImpl.getInstance();
        User userById = instance.getUserById(1);
        System.out.println(userById);
        userById.getFriendsList().forEach(System.out::println);
    }
    @Test
    public void testNews(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        PageHelper.startPage(0, 4);
        List<News> selectRandom = newsDao.getSelectRandom();
        PageInfo<News> pageInfo = new PageInfo<>(selectRandom);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPageSize());
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
        System.out.println(token);
    }
}
