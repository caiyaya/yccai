package com.server.web.common;

/**
 * 错误码
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200,"success"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(9999,"未知错误"),

    /**
     * 用户名不存在
     */
    LOGIN_USERNAME_ERROR(1000,"用户名不存在"),

    LOGIN_USERNAME_LOCK(1003,"用户被锁定"),

    /**
     * 用户名或密码错误
     */
    LOGIN_U_P_ERROR(1001,"用户名或密码错误"),

    LOGIN_CAPTCHA_ERROR(1002,"验证码错误"),

    //sql错误
    SQL_DUPLICATE_KEY_ERROR(2002,"数据已存在"),

    UNAUTHORIZED_ERROR(401,"未授权"),

    UNAUTHORIZED_EXCEPTION(4001,"权限不够");

    /**
     * 结果码
     */
    private int code;

    /**
     * 结果码描述
     */
    private String msg;


    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
