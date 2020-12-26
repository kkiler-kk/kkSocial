package com.kk.test;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.service.IMailServiceImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.LinkData;
import com.kk.util.TokenUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
public class Test {
    @Autowired
    IMailServiceImpl mailService;
    @org.junit.Test
    public void test() {
        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.getUserByEmailAndPassword("kk@qq.com", "123456");
        System.out.println(user);
    }

}
