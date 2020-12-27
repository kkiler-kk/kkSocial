package com.kk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class LinkData {
    public static SqlSessionFactory getSessionFactory() throws IOException {
        InputStream input = Resources.getResourceAsStream("config/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(input);
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
