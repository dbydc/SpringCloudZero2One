package com.dbydc.zero2one.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbydc.zero2one.order.dao.OrderDao;
import com.dbydc.zero2one.order.entity.Order;
import com.dbydc.zero2one.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * 订单服务 Service实现类
 * @author 大白有点菜
 * @className OrderServiceImpl
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements IOrderService {

}
