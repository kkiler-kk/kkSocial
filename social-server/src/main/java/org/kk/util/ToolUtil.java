package org.kk.util;


import org.kk.bean.News;

import java.util.ArrayList;
import java.util.List;

public final class ToolUtil {
    private ToolUtil(){}
    public static final boolean checkNumber(String name, RedisUtil redisUtil) {
        Integer count = 5; //count 限定调用次数可以从数据库中取数据也可以在代码中规定
        Integer limitTime = (60 * 5); //过期时间
        Object o = redisUtil.get(name);
        if (o != null) {
            Integer redisCount = (Integer) o;
            if(redisCount >= count){
                return false;
            }else{
                redisUtil.incr(name, 1);
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
    public static final List<String> splitList(String s, String split){
        if(StrUtil.isEmpty(s,split))return new ArrayList<>();
        String[] split1 = s.split(split);
        return List.of(split1);
    }

}