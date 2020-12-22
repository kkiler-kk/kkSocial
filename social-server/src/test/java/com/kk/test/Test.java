package com.kk.test;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Test {
    @org.junit.Test
    public void test() {
        UserDao instance = UserDaoImpl.getInstance();
        User userById = instance.getUserById(1);
        System.out.println(userById);
        userById.getFriendsList().stream().forEach(System.out::println);
    }
}
