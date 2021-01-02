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

    public static String upload(MultipartFile file, String email){
        if (Objects.equals("", email) && file.isEmpty()) {
            return "";
        }
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
            String realPath = path.replace('/', '\\').substring(1, path.length());
            //用于查看路径是否正确
            System.out.println(realPath);
            email = email + ".jpg";
            //限制文件上传的类型
            String contentType = file.getContentType();
            if (Objects.equals("image/png", contentType) || Objects.equals("image/jpeg", contentType) || Objects.equals("image/jpg", contentType)) {
                File f = new File(realPath, email);
                //完成文件的上传
                file.transferTo(f);
                String path01 = "/upload/" + email;
                System.out.println("图片上传成功!" + path01);
                return path01;
            } else {
                System.out.println("上传失败！");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
