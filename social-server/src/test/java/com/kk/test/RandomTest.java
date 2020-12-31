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
        List<News> selectRandom = newsDao.getSelectRandom();
        for (News news : selectRandom) {
            System.out.println(news);
        }
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
