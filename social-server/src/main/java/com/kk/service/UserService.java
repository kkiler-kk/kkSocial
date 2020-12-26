package com.kk.service;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;
import com.kk.util.LinkData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final static Map<String, Integer> emailCode = new HashMap<>();
    @Autowired
    private IMailServiceImpl mailService;
    private UserService(){
        instance = UserDaoImpl.getInstance();
    }
    private UserDao instance;
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
    public User login(String email, String password){
        User userByEmailAndPassword = instance.getUserByEmailAndPassword(email, password);
        return userByEmailAndPassword;
    }
    public boolean register(User user, Integer code){
        if (emailCode.get(user.getEmail()) != code) {
            return false;
        }
        instance.addUser(user);
        return true;
    }
    public boolean existEmail(String email){
        return instance.getUserByEmailAndPassword(email, null) == null;
    }
    public void sendEmail(String email){
        int random = LinkData.random();
        emailCode.put(email, random);
        mailService.sendSimpleMail(email,"kksocial--验证码","验证码:" + random);
    }
}
