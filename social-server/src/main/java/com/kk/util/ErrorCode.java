package com.kk.util;

public final class ErrorCode {
    //增删改查错误
    public static final Integer INSERT_FAIL = -101;
    public static final Integer DELETE_FAIL = -102;
    public static final Integer UPDATE_FAIL = -103;
    public static final Integer QUERY_FAIL = -104;
    //参数为null 错误
    public static final Integer ILLEGAL_NULL = -201;
    //参数错误
    public static final Integer ILLEGAL_PARAMETER = -202;
    //token过期了
    public static final Integer TOKEN_PAST = -301;
    //404找不到
    public static final Integer NOT_FOUND = -404;
    //成功
    public static final Integer SUCCESS = 200;

}
