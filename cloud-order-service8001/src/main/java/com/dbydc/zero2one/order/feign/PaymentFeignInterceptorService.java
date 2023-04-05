package com.dbydc.zero2one.order.feign;

import com.dbydc.zero2one.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign远程调用Payment服务接口（请求拦截器（RequestInterceptor））
 * @author 大白有点菜
 * @className PaymentFeignInterceptorService
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Service
@FeignClient(value = "cloud-payment-service", url = "localhost:6002/payment",
        contextId = "PaymentFeignInterceptorService", configuration = {FeignConfig.class})
public interface PaymentFeignInterceptorService {
    /**
     * 演示请求拦截器（RequestInterceptor）
     * @return
     */
    @GetMapping(value = "/feign/interceptor", produces = "application/json;charset=UTF-8")
    String paymentFeignInterceptor();
}
