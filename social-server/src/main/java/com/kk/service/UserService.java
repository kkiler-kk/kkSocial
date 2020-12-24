package com.kk.service;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.dao.impl.UserDaoImpl;

import java.util.Objects;

public class UserService {
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
    public String register(User user){
        instance.addUser(user);
        return "success";
    }
}
