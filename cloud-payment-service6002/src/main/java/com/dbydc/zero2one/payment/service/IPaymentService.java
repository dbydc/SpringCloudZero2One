package com.dbydc.zero2one.payment.service;

import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.payment.entity.Payment;

/**
 * 支付服务 Service接口
 * @author 大白有点菜
 * @className IPaymentService
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
public interface IPaymentService {
    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    ResponseData getByOrderNum(String orderNum);

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    ResponseData getById(Long id);

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    ResponseData add(Payment payment);

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    ResponseData deleteByOrderNum(String orderNum);

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    ResponseData deleteById(Long id);
}
