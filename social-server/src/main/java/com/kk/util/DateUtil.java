package com.kk.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String currentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        return sdf.format(date);
    }
}
