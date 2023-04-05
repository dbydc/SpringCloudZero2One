package com.dbydc.zero2one.common.enums;

/**
 * 操作状态 枚举类
 * @author 大白有点菜
 * @className OperateStatusEnum
 * @date 2023-04-02
 * @description
 * @since 1.0
 **/
public enum OperateStatusEnum {
    /**
     * 新增成功：1
     */
    ADD_SUCCESS(1, "新增数据成功"),
    /**
     * 新增失败：-1
     */
    ADD_FAIL(-1, "新增数据失败"),
    /**
     * 删除成功：2
     */
    DELETE_SUCCESS(2, "删除数据成功"),
    /**
     * 删除失败：-2
     */
    DELETE_FAIL(-2, "删除数据失败"),
    /**
     * 修改成功：3
     */
    UPDATE_SUCCESS(3, "修改数据成功"),
    /**
     * 修改失败：-3
     */
    UPDATE_FAIL(-3, "修改数据失败");

    /**
     * 操作状态码
     */
    private final Integer code;
    /**
     * 操作信息
     */
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    OperateStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过操作状态码获取操作信息
     * @param code 操作状态码
     * @return
     */
    public static String getMessageByCode(Integer code) {
        OperateStatusEnum operateStatusEnum = getEnumByCode(code);
        return operateStatusEnum == null ? null : operateStatusEnum.getMessage();
    }

    /**
     * 通过操作状态码获取ResponseCodeEnum对象
     * @param code 操作状态码
     * @return
     */
    public static OperateStatusEnum getEnumByCode(Integer code) {
        if (code == null) {
            return null;
        }
        OperateStatusEnum[] values = OperateStatusEnum.values();
        for (OperateStatusEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
