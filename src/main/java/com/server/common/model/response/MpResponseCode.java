package com.server.common.model.response;

import lombok.Getter;
import com.server.common.model.response.ResultCode;

@Getter
public enum MpResponseCode implements ResultCode {
    FILE_NOT_EXIST(false,24001,"页面名称已存在！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private MpResponseCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
