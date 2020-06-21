package com.server.common.exception;


import com.server.common.model.response.ResultCode;

/**
 * 自定义异常类型
 * @author huanghua
 * @version 1.0
 * @create 2020-06-21 15:02
 **/
public class CustomException extends RuntimeException {

    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }


}
