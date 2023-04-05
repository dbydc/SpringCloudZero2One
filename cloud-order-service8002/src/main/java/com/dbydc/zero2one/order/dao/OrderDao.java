package com.dbydc.zero2one.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbydc.zero2one.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单服务 Dao接口
 * @author 大白有点菜
 * @className OrderDao
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
