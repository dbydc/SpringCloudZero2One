package com.dbydc.zero2one.order.controller;

import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.order.entity.Order;
import com.dbydc.zero2one.order.feign.PaymentFeignService;
import com.dbydc.zero2one.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 订单服务 Controller业务类
 * @author 大白有点菜
 * @className OrderController
 * @date 2023-04-01
 * @description
 * @since 1.0
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:6001";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private PaymentFeignService paymentFeignService;


    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/query/{orderNum}")
    public ResponseData queryByOrderNum(@PathVariable("orderNum") String orderNum) {
        return orderService.getByOrderNum(orderNum);
    }

    /**
     * 通过用户手机号获取批量数据
     * @param userPhone 用户手机号
     * @return
     */
    @GetMapping("/queryList/{userPhone}")
    public ResponseData queryListByPhone(@PathVariable("userPhone") String userPhone) {
        return orderService.getListByPhone(userPhone);
    }

    /**
     * 新增
     * @param order 订单服务实体对象
     * @return
     */
    @PostMapping("/add")
    public ResponseData add(@RequestBody @Validated Order order) {
        return orderService.add(order);
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/delete/{orderNum}")
    public ResponseData deleteByOrderNum(@PathVariable("orderNum") String orderNum) {
        return orderService.deleteByOrderNum(orderNum);
    }

    /**
     * 通过订单号修改数据
     * @param order 订单服务实体对象
     * @return
     */
    @PostMapping("/update")
    public ResponseData updateByOrderNum(@RequestBody Order order) {
        return orderService.updateByOrderNum(order);
    }

    /**
     * 通过订单号远程调用支付服务的接口并获取数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/remoteQuery/{orderNum}")
    public ResponseData remoteQueryByOrderNum(@PathVariable("orderNum") String orderNum) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/queryByOrderNum/" + orderNum, ResponseData.class);
    }
}
