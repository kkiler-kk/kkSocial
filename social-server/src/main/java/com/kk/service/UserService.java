package com.kk.service;

import com.alibaba.fastjson.JSON;
import com.kk.bean.Dto;
import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.ErrorCode;
import com.kk.util.LinkData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final static Map<String, Integer> emailCode = new HashMap<>();
    private final IMailServiceImpl mailService;

    private UserService(){
        instance = UserDaoImpl.getInstance();
        mailService = new IMailServiceImpl();
    }
    private final UserDao instance;
    private static UserService service = null;
    public static UserService getInstance(){
        if (service == null){
            synchronized (UserService.class){
                if(service == null){
                    service = new UserService();
                }
            }
        }
        return service;
    }
    public Dto<String> login(String email, String password){
        User result = instance.getUserByEmailAndPassword(email, password);
        if(result == null){
            return new Dto<String>(ErrorCode.QUERY_FAIL, "查询不到用户");
        }
        Dto<String> success = new Dto<>(JSON.toJSONString(result));
        return success;
    }
    public Dto register(User user, Integer code){
        Dto dto = null;
        if (emailCode.get(user.getEmail()) != code) {
            return new Dto<>(ErrorCode.INSERT_FAIL, "code is error");
        }
        int line = instance.addUser(user);
        if(line > 0){
            return new Dto(ErrorCode.INSERT_FAIL, "insert failed");
        }
        dto = new Dto(ErrorCode.SUCCESS, "SUCCESS");
        return dto;
    }
    public Dto existEmail(String email){
        Dto dto = null;
        if(email == null){
            dto = new Dto(ErrorCode.QUERY_FAIL, "email is null");
            return dto;
        }
        boolean status = instance.getUserByEmailAndPassword(email, null) == null;
        dto = new Dto(ErrorCode.SUCCESS, "SUCCESS");
        dto.setStatus(status);
        return dto;
    }
    public void sendEmail(String email){
        int random = LinkData.random();
        emailCode.put(email, random);
        mailService.sendSimpleMail(email,"kkSocial--验证码","验证码:" + random);
    }
}
