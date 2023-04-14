package com.dbydc.zero2one.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 订单服务 实体类
 * @author 大白有点菜
 * @className Order
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_order")
public class Order {

    /**
     * CREATE TABLE `tb_order` (
     *   `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
     *   `order_num` varchar(64) NOT NULL COMMENT '订单号',
     *   `user_name` varchar(128) DEFAULT NULL COMMENT '用户名',
     *   `user_phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户手机号',
     *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     *   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
     */

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    //@NonNull
    private String orderNum;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;
    private LocalDateTime updateTime;
}
