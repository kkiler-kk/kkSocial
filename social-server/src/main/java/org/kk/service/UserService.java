package org.kk.service;

import org.kk.bean.User;
import org.kk.dao.UserDao;
import org.kk.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        boolean flag = redisUtil.hasKey(i);
        if(!flag){
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
        redisUtil.del(user.getEmail());
        return i > 0 ? ErrorCode.SUCCESS : ErrorCode.UNPREDICTABLE_ERROR;
    }
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }
    public Integer existName(String name){  //此处代码是有bug的 但我还是要提交
        Integer result = ErrorCode.EXIST_CODE;
        boolean existName = redisUtil.hasKey("existName");
        if (!existName){  //不存在 则创建HashSet
            redisUtil.hmset("existName", new HashMap<>());
        }
        Map<Object, Object> map = redisUtil.hmget("existName");
        result = (Integer)map.get(name);
        if (StrUtil.isEmpty(result)) {
            result = userDao.existName(name);
            result = result == 1 ? ErrorCode.EXIST_CODE : ErrorCode.SUCCESS;
            map.put(name, result);
            redisUtil.hmset("existName", map);
            return result;
        }
        return result;
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
