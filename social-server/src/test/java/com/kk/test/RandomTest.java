package com.kk.test;

import com.auth0.jwt.interfaces.Claim;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.*;
import com.kk.dao.*;
import com.kk.dao.impl.*;
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
        PageHelper.startPage(0,1);
        User kk = userDao.getUserByName("KK");
        PageInfo<News> pageInfo = new PageInfo<>(kk.getNewsList());
        System.out.println(kk);
        pageInfo.getList().forEach(System.out::println);
    }
    @Test
    public void testNews(){
        NewsDao newsDao = NewsDaoImpl.getInstance();
        News news = new News();
        news.setContent_text("KK第一次后端Test");
        news.setTag("#Test#");
        news.setId(2);
        int i = newsDao.addNews(news);
        System.out.println(i);
    }
    @Test
    public void testComment(){
        CommentsDao commentsDao = CommentsDaoImpl.getInstance();
        Comments comment = new Comments();
        comment.setId(2);
        comment.setContent("KKTest评论");
        comment.setNew_id(15);
        int i = commentsDao.addComment(comment);
        System.out.println(i);
    }
    @Test
    public void testToken(){
        String token = TokenUtils.token("2");
        System.out.println(token);
        Claim verify = TokenUtils.verify(token);
        if(verify != null){
            System.out.println(verify.asString());
        }else{
            System.out.println("客户暂时未登录");
        }
    }
    @Test
    public void testMessage(){
        MessageDao instance = MsgDaoImpl.getInstance();
        int i = instance.deleteById(2);
        System.out.println(i);
    }
    @Test
    public void testLike(){
        LikeDao instance = LikeDaoImpl.getInstance();
        int i = instance.deleteLike(1);
        System.out.println("i = " + i);
    }
}















