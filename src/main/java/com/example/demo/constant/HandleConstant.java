package com.example.demo.constant;

import java.util.HashMap;
import java.util.Map;

public class HandleConstant {
    public HandleConstant() {
    }

    /**
     * 操作map，定义编码与方法名之间的关系
     */
    public static final Map<String,String> operateMap = new HashMap<>();

    static {
        operateMap.put("handle_001","handle1");         //方法一

    }
}
