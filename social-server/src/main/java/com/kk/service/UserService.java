package com.kk.service;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Service
public class UserService {
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 发送时间
     */
    private Date sendDate;
    @Autowired
    private IMailService mailService;

    private final UserDao userDao;
    private UserService(){
        userDao = UserDaoImpl.getInstance();
    }

    public User getUser(Integer id){
        return userDao.getUserId(id);
    }
    public String login(String email, String password){
        Integer result = userDao.getUserEAndP(email, password);
        if(result == null){
            return null;
        }
        String token = JwtTokenUtil.createToken(String.valueOf(result), "普通用户");
        return token;
    }
    public int register(User user, String code){
        boolean b = ToolUtil.checkNumber(user.getName(), redisUtil);
        Date data = new Date();
        if (!b) return ErrorCode.TOO_MANY;
        int minute = CodeUtil.getMinute(sendDate, data);
        if (minute > 1) return ErrorCode.CODE_PAST;
        if (!redisUtil.get(user.getEmail()).equals(code)) return ErrorCode.CODE_INCORRECT;
        int i = userDao.addUser(user);
        redisUtil.delete(user.getEmail());
        return i > 0 ? ErrorCode.SUCCESS : ErrorCode.UNPREDICTABLE_ERROR;
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
        return userDao.getUserEAndP(email, null) == null;
    }
    public void sendEmail(String email){
        String random = CodeUtil.generateVerCode();
        redisUtil.set(email, random,60);
        sendDate = new Date();
        mailService.sendHtmlMail(email,"kkSocial--验证码","尊敬的用户,<br>" +
                "您好:本次验证码为<strong>" + random + "</strong>本验证码三十分钟内有效,请及时输入(请勿泄露此验证码)</br>" +
                "如非本人操作请忽略(这是一封自动发送邮件, 请不要回复)");
    }
    public int updatePwd(String email, String password){
        return userDao.updatePwd(email, password);
    }
}
