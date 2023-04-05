package com.dbydc.zero2one.common.enums;

/**
 * 响应码枚举类
 * @author 大白有点菜
 * @className ResponseCodeEnum
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
public enum ResponseCodeEnum {
    /**
     * 成功-1000
     */
    SUCCESS(1000, "返回数据成功"),
    /**
     * 空数据-1001
     */
    NULL_DATA(1001, "返回空数据"),
    /**
     * 失败-1002
     */
    ERROR(1002, "返回数据错误");

    /**
     * 响应码
     */
    private final Integer code;
    /**
     * 响应信息
     */
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过响应码获取响应信息
     * @param code 响应码
     * @return
     */
    public static String getMessageByCode(Integer code) {
        ResponseCodeEnum responseCodeEnum = getEnumByCode(code);
        return responseCodeEnum == null ? null : responseCodeEnum.getMessage();
    }

    /**
     * 通过响应码获取ResponseCodeEnum对象
     * @param code 响应码
     * @return
     */
    public static ResponseCodeEnum getEnumByCode(Integer code) {
        if (code == null) {
            return null;
        }
        ResponseCodeEnum[] values = ResponseCodeEnum.values();
        for (ResponseCodeEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
