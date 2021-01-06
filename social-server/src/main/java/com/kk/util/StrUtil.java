package com.kk.util;

import java.util.Objects;
import java.util.regex.Pattern;

public class StrUtil {
    public static boolean isValidEmail(String email) {
        if ((email != null) && (!email.isEmpty())) {
            return Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email);
        }
        return false;
    }
    public static boolean isEmpty(Object... object){
        for (Object o : object) {
            if(o == null || o == ""){
                return false;
            }
        }
        return true;
    }
}
