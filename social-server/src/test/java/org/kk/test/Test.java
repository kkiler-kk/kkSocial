package org.kk.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void random(){
        String[] strs = {"1","2","3"};
        List<String> strings1 = Arrays.asList(strs);
        List<String> strings2 = List.of(strs);
        strs[0] = "4";
        System.out.println(strings1);
        System.out.println(strings2);
    }
}
