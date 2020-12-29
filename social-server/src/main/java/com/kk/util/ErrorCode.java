package com.kk.util;

public final class ErrorCode {
    //增删改查错误
    public static final Integer INSERT_FAIL = -1001;
    public static final Integer DELETE_FAIL = -1002;
    public static final Integer UPDATE_FAIL = -1003;
    public static final Integer QUERY_FAIL = -1004;
    //参数为null 错误
    public static final Integer ILLEGAL_NULL = -2001;
    //参数错误
    public static final Integer ILLEGAL_PARAMETER = -2002;
    //token过期了
    public static final Integer TOKEN_PAST = -3001;
    //成功
    public static final Integer SUCCESS = 200;


}
