package com.kk.test;

import cn.hutool.core.date.DateUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void random() {
        String today = DateUtil.today();
        System.out.println("today = " + today);
    }
}
