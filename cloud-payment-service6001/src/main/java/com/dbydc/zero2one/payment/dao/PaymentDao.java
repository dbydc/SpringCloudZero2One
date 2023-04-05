package com.dbydc.zero2one.payment.dao;

import com.dbydc.zero2one.payment.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 支付服务 Dao接口
 * @author 大白有点菜
 * @className PaymentDao
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
//@Mapper //如果不在启动类添加 @MapperScan 注解进行dao包扫描，那么每个Dao接口都需要加上这个 @Mapper 注解
public interface PaymentDao {
    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    Payment getByOrderNum(@Param("orderNum") String orderNum);

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    Payment getById(@Param("id") Long id);

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    int add(@Param("payment") Payment payment);

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    int deleteByOrderNum(@Param("orderNum") String orderNum);

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    int deleteById(@Param("id") Long id);
}
