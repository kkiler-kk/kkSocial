package com.kk.util;


import com.kk.bean.News;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

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
                redisUtil.set(name,redisCount + 1,limitTime);
                return true;
            }
        }else{
            redisUtil.set(name, 1, limitTime); //指定过期时间
            return true;
        }
    }
    public static void setList(List<News> newsList){
        if (StrUtil.isEmpty(newsList)) {
            return;
        }
        newsList.forEach(news -> {
            if(!StrUtil.isEmpty(news.getPicture())){
                news.setImgList(ToolUtil.splitList(news.getPicture(),"&"));
            }
        });
    }
    public static List<String> splitList(String s, String split){
        if(StrUtil.isEmpty(s,split))return new ArrayList<>();
        String[] split1 = s.split(split);
        return List.of(split1);
    }

}