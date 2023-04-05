package com.dbydc.zero2one.order.dao;

import com.dbydc.zero2one.order.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单服务 Dao接口
 * @author 大白有点菜
 * @className OrderDao
 * @date 2023-04-01
 * @description
 * @since 1.0
 **/
//@Mapper //如果不在启动类添加 @MapperScan 注解进行dao包扫描，那么每个Dao接口都需要加上这个 @Mapper 注解
public interface OrderDao {

    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    Order getByOrderNum(@Param("orderNum") String orderNum);

    /**
     * 通过用户手机号获取批量数据
     * @param userPhone 用户手机号
     * @return
     */
    List<Order> getListByPhone(@Param("userPhone") String userPhone);

    /**
     * 新增
     * @param order 订单服务实体对象
     * @return
     */
    int add(@Param("order") Order order);

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    int deleteByOrderNum(@Param("orderNum") String orderNum);

    /**
     * 通过订单号修改数据
     * @param order 订单服务实体对象
     * @return
     */
    int updateByOrderNum(@Param("order") Order order);
}
