package com.kk.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.StrUtil;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Test {
    @org.junit.Test
    public void test() {
        UserDao instance = UserDaoImpl.getInstance();
        User userById = instance.getUserById(1);
        String s = JSON.toJSONString(userById);
        System.out.println(s);

    }
}
