package com.dbydc.zero2one.order.request;

import lombok.Data;

/**
 * 订单服务 请求实体类
 * @author 大白有点菜
 * @className OrderRequest
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Data
public class OrderRequest {
    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userPhone;
}
