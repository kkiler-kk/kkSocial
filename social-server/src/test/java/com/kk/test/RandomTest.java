package com.kk.test;

import com.kk.DemoApplication;
import com.kk.service.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Component
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)

public class RandomTest {
    @Autowired
    IMailService service;
    @Test
    public void hello(){
        System.out.println("Hello World");
    }
    @Test
    public void senEmail(){
        service.sendSimpleMail("toholyforyou@outlook.com","Test","Test");
    }
}
