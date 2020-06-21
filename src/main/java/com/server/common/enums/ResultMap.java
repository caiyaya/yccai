//package com.server.common.enums;
//
//import java.util.HashMap;
//
//public class ResultMap extends HashMap<String, Object> {
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 状态码
//     */
//    public static final String CODE_TAG = "code";
//
//    /**
//     * 返回内容
//     */
//    public static final String MSG_TAG = "msg";
//
//    /**
//     * 数据对象
//     */
//    public static final String DATA_TAG = "data";
//
//    /**
//     * 初始化一个新创建的 ResultMap 对象，使其表示一个空消息。
//     */
//    public ResultMap() {
//    }
//
//    /**
//     * 初始化一个新创建的 ResultMap 对象
//     *
//     * @param code 状态码
//     * @param msg  返回内容
//     */
//    public ResultMap(int code, String msg) {
//        super.put(CODE_TAG, code);
//        super.put(MSG_TAG, msg);
//    }
//
//    /**
//     * 初始化一个新创建的 ResultMap 对象
//     *
//     * @param code 状态码
//     * @param msg  返回内容
//     * @param data 数据对象
//     */
//    public ResultMap(int code, String msg, Object data) {
//        super.put(CODE_TAG, code);
//        super.put(MSG_TAG, msg);
//        if (data != null) {
//            super.put(DATA_TAG, data);
//        }
//    }
//
//    /**
//     * 返回成功消息
//     *
//     * @return 成功消息
//     */
//    public static ResultMap success() {
//        return ResultMap.success("操作成功");
//    }
//
//    /**
//     * 返回成功数据
//     *
//     * @return 成功消息
//     */
//    public static ResultMap success(Object data) {
//        return ResultMap.success("操作成功", data);
//    }
//
//    public static ResultMap page(Object data) {
//        return ResultMap.success("操作成功", data);
//    }
//
//    /**
//     * 返回成功消息
//     *
//     * @param msg 返回内容
//     * @return 成功消息
//     */
//    public static ResultMap success(String msg) {
//        return ResultMap.success(msg, null);
//    }
//
//    /**
//     * 返回成功消息
//     *
//     * @param msg  返回内容
//     * @param data 数据对象
//     * @return 成功消息
//     */
//    public static ResultMap success(String msg, Object data) {
//        return new ResultMap(200, msg, data);
//    }
//
//    /**
//     * 返回错误消息
//     *
//     * @return
//     */
//    public static ResultMap error() {
//        return ResultMap.error("操作失败");
//    }
//
//    /**
//     * 返回错误消息
//     *
//     * @param msg 返回内容
//     * @return 警告消息
//     */
//    public static ResultMap error(String msg) {
//        return ResultMap.error(msg, null);
//    }
//
//    /**
//     * 返回错误消息
//     *
//     * @param msg  返回内容
//     * @param data 数据对象
//     * @return 警告消息
//     */
//    public static ResultMap error(String msg, Object data) {
//        return new ResultMap(1000, msg, data);
//    }
//
//    /**
//     * 返回错误消息
//     *
//     * @param code 状态码
//     * @param msg  返回内容
//     * @return 警告消息
//     */
//    public static ResultMap error(int code, String msg) {
//        return new ResultMap(code, msg, null);
//    }
//
//    public static ResultMap error(ResultCode unknownError) {
//        return new ResultMap(unknownError.getCode(), unknownError.getMsg(), null);
//    }
//}
