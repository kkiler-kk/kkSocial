package com.kk.test;

import com.kk.service.IMailService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
public class Test {

    /**
     * 测试发送文本邮件
     */
    @org.junit.Test
    public void sendmail() {
        IMailService mailService = new IMailService();
        mailService.sendSimpleMail("3471435758@qq.com","主题：你好普通邮件","内容：第一封邮件");
    }

    @org.junit.Test
    public void sendmailHtml(){
        IMailService mailService = new IMailService();
        mailService.sendHtmlMail("smfx1314@163.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }
}
