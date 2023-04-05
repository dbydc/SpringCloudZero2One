package com.dbydc.zero2one.order.service;

import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.order.entity.Order;

/**
 * 订单服务 Service接口
 * @author 大白有点菜
 * @className IOrderService
 * @date 2023-04-01
 * @description
 * @since 1.0
 **/
public interface IOrderService {
    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    ResponseData getByOrderNum(String orderNum);

    /**
     * 通过用户手机号获取批量数据
     * @param userPhone 用户手机号
     * @return
     */
    ResponseData getListByPhone(String userPhone);

    /**
     * 新增
     * @param order 订单服务实体对象
     * @return
     */
    ResponseData add(Order order);

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    ResponseData deleteByOrderNum(String orderNum);

    /**
     * 通过订单号修改数据
     * @param order 订单服务实体对象
     * @return
     */
    ResponseData updateByOrderNum(Order order);
}
