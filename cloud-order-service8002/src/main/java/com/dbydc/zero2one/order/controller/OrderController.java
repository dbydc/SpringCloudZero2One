package com.dbydc.zero2one.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dbydc.zero2one.common.enums.ResponseCodeEnum;
import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.order.entity.Order;
import com.dbydc.zero2one.order.request.OrderRequest;
import com.dbydc.zero2one.order.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单服务 Controller业务类
 * @author 大白有点菜
 * @className OrderController
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 通过手机号查询批量数据
     * @param orderRequest 订单请求实体
     * @return
     */
    @PostMapping("/findList")
    public ResponseData findList(@RequestBody OrderRequest orderRequest) {

        //Order order = new Order();
        //BeanUtils.copyProperties(orderRequest, order);
        //LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>(order);
        //List<Order> orders = orderService.list(queryWrapper);

        //写法一（LambdaQueryWrapper）：通过手机号查询批量数据
        LambdaQueryWrapper<Order> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Order::getUserPhone, orderRequest.getUserPhone());

        //写法二（QueryWrapper）：通过手机号查询批量数据
        QueryWrapper<Order> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("user_phone", orderRequest.getUserPhone());

        //List<Order> orders = orderService.list(queryWrapper1);
        List<Order> orders = orderService.list(queryWrapper2);

        return CollectionUtils.isEmpty(orders) ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), orders);
    }
}
