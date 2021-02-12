package org.kk.service;

import org.kk.bean.User;
import org.kk.dao.UserDao;
import org.kk.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
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
    @Autowired
    private UserDao userDao;

    public User getUser(Integer id){
        String i = String.valueOf(id);
        boolean flag = redisUtil.hashKey(i);
        System.out.println(flag);
        if(flag){
            User byData = userDao.getByData(id);
            redisUtil.set(i, byData,  30 *  (60 * 60) * 24);
        }
        return (User) redisUtil.get(i);
    }
    public String login(String email, String password) throws UnsupportedEncodingException {
        Integer result = userDao.getUserEAndP(email, password);
        if(result == null) return null;
        String token = JwtTokenUtil.createToken(String.valueOf(result));
        return token;
    }
    public int register(User user, String code){
        boolean b = ToolUtil.checkNumber(user.getName(), redisUtil);
        if (!b) return ErrorCode.TOO_MANY;
        int minute = CodeUtil.getMinute(sendDate, new Date());
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
    public boolean isAttention(Integer id, String name){
        return userDao.isAttention(id, name) != 0;
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
