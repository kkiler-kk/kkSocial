package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.News;
import com.kk.bean.PageResult;
import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.CodeUtil;
import com.kk.util.PageUtils;
import com.kk.util.StrUtil;
import com.kk.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Service
public class UserService {
    private final static Map<String, String> emailCode = new HashMap<>();
    /**
     * 发送时间
     */
    private Date sendDate;
    @Autowired
    private IMailService mailService;

    private UserService(){
        userDao = UserDaoImpl.getInstance();
    }
    private final UserDao userDao;

    public String login(String email, String password){
        User result = userDao.getUserByEmailAndPassword(email, password);
        if(result == null){
            return null;
        }
        String token = TokenUtils.token(result.getId().toString());
        return token;
    }
    public int register(User user, String code){
        Date data = new Date();
        int minute = CodeUtil.getMinute(sendDate, data);
        if (minute > 30){
            return -1;
        }
        if (!emailCode.get(user.getEmail()).equals(code)) {
            return -2;
        }
        int i = userDao.addUser(user);
        emailCode.remove(user.getEmail());
        return i;
    }
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }
    public User existName(String name){
        if(StrUtil.isEmpty(name)) return null;
        User userByName = userDao.getUserByName(name);
        return userByName;
    }

    public boolean existEmail(String email){
        return userDao.getUserByEmailAndPassword(email, null) == null;
    }
    public void sendEmail(String email){
        String random = CodeUtil.generateVerCode();
        emailCode.put(email, random);
        sendDate = new Date();
        mailService.sendHtmlMail(email,"kkSocial--验证码","尊敬的用户,<br>" +
                "您好:本次验证码为<strong>" + random + "</strong>本验证码三十分钟内有效,请及时输入(请勿泄露此验证码)</br>" +
                "如非本人操作请忽略(这是一封自动发送邮件, 请不要回复)");
    }
    public int updatePwd(String email, String password){
        return userDao.updatePwd(email, password);
    }
}
