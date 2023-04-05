package com.dbydc.zero2one.order.feign;

import com.dbydc.zero2one.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign远程调用Payment服务接口（主要是 演示ReadTimeout超时）
 * @author 大白有点菜
 * @className PaymentFeignTimeoutService
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Service
@FeignClient(value = "cloud-payment-service", url = "localhost:6002/payment",
        contextId = "PaymentFeignTimeoutService", configuration = {FeignConfig.class})
public interface PaymentFeignTimeoutService {
    /**
     * 演示ReadTimeout超时
     * @return
     */
    @GetMapping(value = "/feign/timeout", produces = "application/json;charset=UTF-8")
    String paymentFeignTimeOut();
}
