package org.kk.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public final class ErrorCode {
    public static final Map<Integer, String> ERROR_MAP = new HashMap<>();
    private ErrorCode(){}

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
    //已经存在了
    public static final Integer EXIST_CODE = -204;
    //用户不存在
    public static final Integer USER_NOTHINGNESS = -205;
    //token过期了
    public static final Integer TOKEN_PAST = -301;
    //token找不到
    public static final Integer TOKEN_NOT = -302;
    //验证码过期了
    public static final Integer CODE_PAST = -303;
    //请求次数过多
    public static final  Integer TOO_MANY = -304;
    //用户未登录
    public static final Integer NOT_LOGIN = -305;

    //404找不到
    public static final Integer NOT_FOUND = -404;
    //无法预知的错误
    public static final Integer UNPREDICTABLE_ERROR = -501;
    //成功
    public static final Integer SUCCESS = 200;
    static {

        ERROR_MAP.put(INSERT_FAIL, "添加错误!!!");
        ERROR_MAP.put(DELETE_FAIL, "删除错误!!!");
        ERROR_MAP.put(UPDATE_FAIL, "修改错误!!!");
        ERROR_MAP.put(QUERY_FAIL, "查询错误!!!");
        ERROR_MAP.put(ILLEGAL_NULL, "参数为NULL");
        ERROR_MAP.put(ILLEGAL_PARAMETER, "参数错误!!!");
        ERROR_MAP.put(CODE_INCORRECT, "验证码不正确!!!");
        ERROR_MAP.put(TOKEN_PAST, "token过期了! 请重新登录!");
        ERROR_MAP.put(TOKEN_NOT, "token找不到! 请重新登录!");
        ERROR_MAP.put(CODE_PAST, "验证码过期了!!!");
        ERROR_MAP.put(TOO_MANY, "请求次数过多请稍后重试!!!");
        ERROR_MAP.put(NOT_FOUND, "404找不到!!!");
        ERROR_MAP.put(EXIST_CODE, "已存在!!!");
        ERROR_MAP.put(UNPREDICTABLE_ERROR, "无法预知的错误!!!");
        ERROR_MAP.put(NOT_LOGIN, "用户未登录");
        ERROR_MAP.put(USER_NOTHINGNESS, "用户不存在!!!");
        ERROR_MAP.put(SUCCESS, "OK");
    }
}
