package org.kk.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void testGet(){
        Map<Object, Object> kk = redisUtil.hmget("KK");
        kk.put("CRY", 20);
        System.out.println(kk);
    }
    @Test
    public void get(){
        Map<Object, Object> kk = redisUtil.hmget("KK");
        System.out.println(kk);
    }
    @Test
    public void testSet(){
        var map = new HashMap<Object, Object>();
        map.put("name", "KK");
        map.put("age", 18);
        map.put("address", "宁波");
        boolean kk = redisUtil.hmset("KK", map);
        System.out.println(kk);
        Map<Object, Object> kk1 = redisUtil.hmget("KK");
        System.out.println(kk1);
    }
}
