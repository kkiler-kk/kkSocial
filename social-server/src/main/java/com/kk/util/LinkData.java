package com.kk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class LinkData {
    private static SqlSession openSession;
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSessionFactory() throws IOException {
        InputStream input = Resources.getResourceAsStream("config/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(input);
    }

    public static <T> T createClass(Class<T> clazz){

        try {
            sqlSessionFactory = LinkData.getSessionFactory();
            openSession = sqlSessionFactory.openSession();
            Object mapper = openSession.getMapper(clazz);
            return (T)mapper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) new Object();
    }
    public static void closeSession(){
        if(openSession !=null){
            openSession.close();
        }
    }
    public static void commit(){
        if(openSession != null){
            openSession.commit();
        }
    }
}
