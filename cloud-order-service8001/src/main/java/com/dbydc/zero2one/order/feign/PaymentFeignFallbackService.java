package com.dbydc.zero2one.order.feign;

import com.dbydc.zero2one.common.config.FeignConfig;
import com.dbydc.zero2one.order.feign.fallback.PaymentFeignFallBackServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign远程调用Payment服务接口（使用自定义的配置类 和 Fallback）
 * @author 大白有点菜
 * @className PaymentFeignFallbackService
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Service
@FeignClient(value = "cloud-payment-service", url = "localhost:6002/payment", contextId = "PaymentFeignFallbackService",
        configuration = FeignConfig.class, fallbackFactory = PaymentFeignFallBackServiceFallbackFactory.class)
public interface PaymentFeignFallbackService {
    /**
     * 演示Fallback
     * @return
     */
    @GetMapping(value = "/feign/fallback", produces = "application/json;charset=UTF-8")
    String paymentFeignFallback();
}
