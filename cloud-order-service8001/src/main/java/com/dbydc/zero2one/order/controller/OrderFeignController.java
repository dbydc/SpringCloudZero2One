package com.dbydc.zero2one.order.controller;

import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.order.feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务 Controller业务类 Feign远程调用
 * @author 大白有点菜
 * @className OrderFeignController
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@RestController
@RequestMapping("order")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @Autowired
    private PaymentFeignConfigurationService configurationService;

    @Autowired
    private PaymentFeignContractService contractService;

    @Autowired
    private PaymentFeignTimeoutService timeoutService;

    @Autowired
    private PaymentFeignInterceptorService interceptorService;

    @Autowired
    private PaymentFeignFallbackService fallbackService;

    /**
     * 通过订单号获取数据（Configuration配置类）
     * @param orderNum
     * @return
     */
    @GetMapping("/feign/queryByOrderNum/{orderNum}")
    public ResponseData queryByOrderNum(@PathVariable("orderNum") String orderNum) {
        return configurationService.queryByOrderNum(orderNum);
    }

    /**
     * 通过订单号获取数据（application.yml）
     * @param orderNum
     * @return
     */
    @GetMapping("/feign/query/{orderNum}")
    public ResponseData queryFeign(@PathVariable("orderNum") String orderNum) {
        return paymentFeignService.queryFeign(orderNum);
    }

    /***
     * 演示ReadTimeout超时
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeOut() {
        String value = timeoutService.paymentFeignTimeOut();
        System.out.println(value);
        return value;
    }

    /**
     * 演示契约配置（FeignContractConfig配置文件）
     * 1、Contract.Default()：Feign原生默认契约，不支持SpringMvc注解。
     * 2、SpringMvcContract()：OpenFeign 支持SpringMvc注解。
     * @return
     */
    @GetMapping(value = "/feign/contract/{id}")
    public String paymentFeignContract(@PathVariable("id") int id) {
        String value = contractService.paymentFeignContract(id);
        System.out.println(value);
        return value;
    }

    /**
     * 演示请求拦截器（RequestInterceptor）
     * @return
     */
    @GetMapping(value = "/feign/interceptor")
    public String paymentFeignInterceptor() {
        String value = interceptorService.paymentFeignInterceptor();
        System.out.println(value);
        return value;
    }

    /**
     * 演示Fallback
     * @return
     */
    @GetMapping(value = "/feign/fallback")
    public String paymentFeignFallback() {
        String value = fallbackService.paymentFeignFallback();
        System.out.println(value);
        return value;
    }
}
