package org.kk.util;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public final class StrUtil {
   private StrUtil(){}
    public static final boolean isValidEmail(String email) {
        if ((email != null) && (!email.isEmpty())) {
            return Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email);
        }
        return false;
    }

    public static boolean isEmpty(Object... object){
        for (Object o : object) {
            if(o == null || Objects.equals(o, "")){
                return true;
            }
        }
        return false;
    }
    public static void updateList(List<String> list){
        Integer i = 0;
        for (String s : list) {
            list.set(i++,s.split(" ")[0].replaceAll("#", " ").strip());
        }
    }
}
