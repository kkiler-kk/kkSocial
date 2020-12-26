package com.kk.test;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.service.IMailServiceImpl;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.LinkData;
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
        int random = LinkData.random();
        System.out.println(random);
        random = LinkData.random();
        System.out.println(random);
        random = LinkData.random();
        System.out.println(random);
        random = LinkData.random();
        System.out.println(random);
    }

    /**
     * 测试发送文本邮件
     */
    @org.junit.Test
    public void sendmail() {
        mailService.sendSimpleMail("3258261356@qq.com","主题：你好普通邮件","内容：第一封邮件");
    }

    @org.junit.Test
    public void sendmailHtml(){
        mailService.sendHtmlMail("3258261356@qq.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }
}
