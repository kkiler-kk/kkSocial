package org.kk.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void random(){
        List<String> list = new ArrayList<>();
        list.add("#Hea#");
        list.add("#waea#");
        test(list);
        System.out.println(list);
    }
    public void test(List<String> list){
        Integer i = 0;
        for (String s : list) {
            list.set(i++,s.split(" ")[0].replaceAll("#", " ").strip());
        }
    }
}
