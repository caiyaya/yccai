package com.server.common.exception;


import com.server.common.model.response.ResultCode;

/**
 * @author huanghua
 * @version 1.0
 * @create 2020-06-21 15:02
 **/
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
