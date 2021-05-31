package org.kk.test;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test {
    @org.junit.Test
    public void test(){
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(DateUtil.today(), "yyyy-MM-dd");
        System.out.println(date);
    }
}
