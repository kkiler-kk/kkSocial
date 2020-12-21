package com.kk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class LinkData {
    public static SqlSessionFactory getSessionFactory() throws IOException {
        InputStream input = Resources.getResourceAsStream("config/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(input);
    }
}
