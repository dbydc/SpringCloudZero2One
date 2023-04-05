package com.dbydc.zero2one.order.service.impl;

import com.dbydc.zero2one.common.enums.ResponseCodeEnum;
import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.order.dao.OrderDao;
import com.dbydc.zero2one.order.entity.Order;
import com.dbydc.zero2one.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 订单服务 Service实现类
 * @author 大白有点菜
 * @className OrderServiceImpl
 * @date 2023-04-01
 * @description
 * @since 1.0
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    /**
     * 写法一：Spring的注解。将对象交由Spring去管理，官方不推荐这种写法。
     */
    @Autowired
    private OrderDao orderDao;

//    private OrderDao orderDao;
//    /**
//     * 写法二：Spring的注解。Setter方式注入对象，官方推荐这种写法。
//     * @param orderDao
//     */
//    @Autowired
//    public void setOrderDao(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }

    /**
     * 写法三：Java的注解。全称javax.annotation.Resource,它属于JSR-250规范的一个注解，包含Jakarta EE（J2EE）中。
     */
    //@Resource
    //private OrderDao orderDao;

    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @Override
    public ResponseData getByOrderNum(String orderNum) {
        Order order = orderDao.getByOrderNum(orderNum);
        return order == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), order);
    }

    /**
     * 通过用户手机号获取批量数据
     * @param userPhone 用户手机号
     * @return
     */
    @Override
    public ResponseData getListByPhone(String userPhone) {
        List<Order> orderList = orderDao.getListByPhone(userPhone);
        return (orderList == null || orderList.size() == 0) ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), orderList);
    }

    /**
     * 新增
     * @param order 订单服务实体对象
     * @return
     */
    @Override
    public ResponseData add(Order order) {
        Date date = new Date();
        order.setCreateTime(date);
        order.setUpdateTime(date);
        int addResult = orderDao.add(order);
        return addResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), "新增数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "新增数据失败");
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @Override
    public ResponseData deleteByOrderNum(String orderNum) {
        int deleteResult = orderDao.deleteByOrderNum(orderNum);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), "删除数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "删除数据失败");
    }

    /**
     * 通过订单号修改数据
     * @param order 订单服务实体对象
     * @return
     */
    @Override
    public ResponseData updateByOrderNum(Order order) {
        if (Objects.nonNull(order)) {
            order.setUpdateTime(new Date());
        }
        int updateResult = orderDao.updateByOrderNum(order);
        return updateResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), "修改数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "修改数据失败");
    }
}
