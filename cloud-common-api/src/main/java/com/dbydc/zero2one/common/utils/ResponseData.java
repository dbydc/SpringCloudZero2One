package com.dbydc.zero2one.common.utils;

import com.dbydc.zero2one.common.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * 数据返回响应类
 * @author 大白有点菜
 * @className ResponseData
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
public class ResponseData implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应数据
     */
    private Object data;
    /**
     * 响应信息
     */
    private String message;

    public ResponseData() {

    }

    /**
     * 构造函数
     * @param code 响应码
     * @param data 响应数据
     * @param message 响应信息
     */
    public ResponseData(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * Success，无入参
     * @return
     */
    public static ResponseData success() {
        return new ResponseData(ResponseCodeEnum.NULL_DATA.getCode(), null, ResponseCodeEnum.NULL_DATA.getMessage());
    }

    /**
     * Success，入参：code
     * @param code 响应码
     * @return
     */
    public static ResponseData success(Integer code) {
        return new ResponseData(code, null, ResponseCodeEnum.NULL_DATA.getMessage());
    }

    /**
     * Success，入参：code、data
     * @param code 响应码
     * @param data 响应数据
     * @return
     */
    public static ResponseData success(Integer code, Object data) {
        return new ResponseData(code, data, ResponseCodeEnum.SUCCESS.getMessage());
    }

    /**
     * Success，入参：code、message
     * @param code 响应码
     * @param message 响应信息
     * @return
     */
    public static ResponseData success(Integer code, String message) {
        return new ResponseData(code, null, message);
    }

    /**
     * Success，入参：code、data、message
     * @param code 响应码
     * @param data 响应数据
     * @param message 响应信息
     * @return
     */
    public static ResponseData success(Integer code, Object data, String message) {
        return new ResponseData(code, data, message);
    }

    /**
     * Error，入参：code
     * @param code 响应码
     * @return
     */
    public static ResponseData error(Integer code) {
        return new ResponseData(code, null, ResponseCodeEnum.ERROR.getMessage());
    }

    /**
     * Error，入参：code、message
     * @param code 响应码
     * @param message 响应信息
     * @return
     */
    public static ResponseData error(Integer code, String message) {
        return new ResponseData(code, null, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
