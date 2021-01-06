package com.kk.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

public class ToolUtil {
    public static boolean checkNumber(String name, RedisUtil redisUtil) {
        Integer count = 5; //count 限定调用次数可以从数据库中取数据也可以在代码中规定
        Integer limitTime = 60; //过期时间
        Integer redisCount = null;
        Object o = redisUtil.get(name);
        if (o != null) {
            redisCount = (Integer) o;
            if(redisCount >= count){
                return false;
            }else{
                redisUtil.set(name,redisCount + 1);
                return true;
            }
        }else{
            redisUtil.set(name, 1, limitTime); //指定过期时间
            return true;
        }
    }

}
