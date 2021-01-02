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
    //验证码不正确
    public static final Integer CODE_INCORRECT = -203;

    //token过期了
    public static final Integer TOKEN_PAST = -301;
    //验证码过期了
    public static final Integer CODE_PAST = -304;
    //请求次数过多
    public static final  Integer TOO_MANY = -305;

    //404找不到
    public static final Integer NOT_FOUND = -404;

    //成功
    public static final Integer SUCCESS = 200;

}
