package org.kk.test;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.auth0.jwt.interfaces.Claim;
import org.kk.bean.News;
import org.kk.bean.User;
import org.kk.bean.UserInfo;
import org.kk.dao.NewsDao;
import org.kk.dao.UserDao;
import org.kk.dao.UserInfoDao;
import org.kk.service.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kk.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SuppressWarnings("all")
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
        User user = new User("test", "test", "test", 0, "test", DateUtil.today());
        int i = userDao.addUser(user);
        System.out.println(i);
    }
    @Test
    public void testUserInfo(){
        UserInfo userHome = userInfoDao.getUserHome(1);
        System.out.println(userHome);
        System.out.println(userHome.getNewsList());
    }
    @Test
    public void testNews(){
        String search = newsDao.getSearch();
        String[] s = search.split(" ");
        System.out.println(s[0].replaceAll("#", " ").strip());
    }
    @Test
    public void testJwt() throws Exception {
        String token = JwtTokenUtil.createToken("2");
        System.out.println(token);
        Boolean stringClaimMap = JwtTokenUtil.checkJWT(token);
        System.out.println(stringClaimMap);
        String userId = JwtTokenUtil.getUserId(token);
        System.out.println(userId);
        boolean expiration = JwtTokenUtil.isExpiration(token);
        System.out.println(expiration);
    }
}
