package org.kk.test;

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

import java.util.List;
import java.util.Map;


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
        Integer kk = userDao.isAttention(1, "KK");
        System.out.println(kk);
    }
    @Test
    public void testUserInfo(){
        UserInfo userHome = userInfoDao.getUserHome(1);
        System.out.println(userHome);
        System.out.println(userHome.getNewsList());
    }
    @Test
    public void testNews(){
        List<News> selectRandom = newsDao.getSelectRandom();
        String s = JSONArray.toJSONString(selectRandom);
        System.out.println(s);
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
