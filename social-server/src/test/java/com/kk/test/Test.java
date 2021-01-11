package com.kk.test;

import cn.hutool.core.date.DateUtil;
import com.kk.util.ToolUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void random() {
        List<String> strings = ToolUtil.splitList("a.jpg/b.jpg/c.jpg", "/");
        System.out.println("strings = " + strings);
    }
}
