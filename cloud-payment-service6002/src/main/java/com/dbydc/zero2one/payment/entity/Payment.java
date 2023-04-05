package com.dbydc.zero2one.payment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付服务 实体类
 * @author 大白有点菜
 * @className Payment
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    /**
     * CREATE TABLE `tb_payment` (
     *   `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
     *   `order_num` varchar(64) NOT NULL COMMENT '订单号',
     *   `payment_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
     *   `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     *   `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
     */

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 订单号
     */
    @NonNull
    private String orderNum;

    /**
     * 支付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
