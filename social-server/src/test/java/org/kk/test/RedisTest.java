package org.kk.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void testGet(){
        Object kk = redisUtil.lGetIndex("kk", 0);
        System.out.println(kk);
    }
    @Test
    public void testSet(){
        redisUtil.lSet("kk", "CRY");
        redisUtil.lSet("kk", "KK");
    }
}
