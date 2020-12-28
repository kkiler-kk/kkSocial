package com.kk.util;

public final class ErrorCode {
    //增删改查错误
    public static final Integer INSERT_FAIL = -10001;
    public static final Integer DELETE_FAIL = -10002;
    public static final Integer UPDATE_FAIL = -10003;
    public static final Integer QUERY_FAIL = -10004;
    //参数为null 错误
    public static final  Integer ILLEGAL_NULL = -20001;
    //参数错误
    public static final Integer ILLEGAL_PARAMETER = -20002;
    //成功
    public static final Integer SUCCESS = 200;
}
