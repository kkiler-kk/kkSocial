package com.kk.service;

import com.alibaba.fastjson.JSON;
import com.kk.bean.Dto;
import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.CodeUtil;
import com.kk.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Service
public class UserService {
    private final static Map<String, String> emailCode = new HashMap<>();
    @Autowired
    private IMailService mailService;

    private UserService(){
        instance = UserDaoImpl.getInstance();
    }
    private final UserDao instance;

    public String login(String email, String password){
        User result = instance.getUserByEmailAndPassword(email, password);
        if(result == null){
            return null;
        }
        return JSON.toJSONString(result);
    }
    public boolean register(User user, String code){
        if (!emailCode.get(user.getEmail()).equals(code)) {
            return false;
        }
        int i = instance.addUser(user);
        return i > 0;
    }
    public boolean existEmail(String email){
        return instance.getUserByEmailAndPassword(email, null) == null;
    }
    public void sendEmail(String email){
        String random = CodeUtil.generateVerCode();
        emailCode.put(email, random);
        mailService.sendSimpleMail(email,"kkSocial--验证码","验证码:" + random);
    }
    public int updatePwd(String email, String password){
        return instance.updatePwd(email, password);
    }
}
