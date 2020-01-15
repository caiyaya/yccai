package com.example.demo.controller;

import com.example.demo.dto.RequestDTO;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class BaseController {

    protected Object getResult(Map<String, String> operateMap, Object serviceName, RequestDTO requestDto) throws InvocationTargetException, IllegalAccessException {
        Object obj = null;
        String errorDesc = "请求的业务编码找不到对应的方法";
        String methodName = operateMap.get(requestDto.getServiceNo());
        if (!StringUtils.isEmpty(methodName)) {
            Method method = null;
            try {
                // 反射
                method = serviceName.getClass().getMethod(methodName, RequestDTO.class);
                obj = method.invoke(serviceName, requestDto);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

}
