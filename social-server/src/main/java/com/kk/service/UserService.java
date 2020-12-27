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
    public Dto register(User user, String code){
        Dto dto = null;
        if (emailCode.get(user.getEmail()) != code) {
            return new Dto<>(ErrorCode.INSERT_FAIL, "验证码错误");
        }
        int line = instance.addUser(user);
        if(line < 0){
            return new Dto(ErrorCode.ILLEGAL_PARAMETER, "参数为空");
        }
        dto = new Dto(ErrorCode.SUCCESS, "添加成功");
        return dto;
    }
    public Dto existEmail(String email){
        Dto dto = null;
        if(email == null){
            dto = new Dto(ErrorCode.QUERY_FAIL, "Email为空");
            return dto;
        }
        boolean status = instance.getUserByEmailAndPassword(email, null) == null;
        dto = new Dto(ErrorCode.SUCCESS, "查询成功!true可以false代表已又");
        dto.setStatus(status);
        return dto;
    }
    public void sendEmail(String email){
        String random = CodeUtil.generateVerCode();
        emailCode.put(email, random);
        mailService.sendSimpleMail(email,"kkSocial--验证码","验证码:" + random);
    }
}
