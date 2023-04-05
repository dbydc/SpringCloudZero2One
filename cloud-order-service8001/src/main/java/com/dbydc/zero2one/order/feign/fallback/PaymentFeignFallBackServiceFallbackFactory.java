package com.dbydc.zero2one.order.feign.fallback;

import com.dbydc.zero2one.order.feign.PaymentFeignFallbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * FallbackFactory实现远程调用Payment服务访问异常触发回退原因
 * @author 大白有点菜
 * @className PaymentFeignFallBackServiceFallbackFactory
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Component
@Slf4j
public class PaymentFeignFallBackServiceFallbackFactory implements FallbackFactory<PaymentFeignFallbackService> {
    @Override
    public PaymentFeignFallbackService create(Throwable cause) {
        log.error("哎哟，大白有点菜掉粉了呢，原因是Fallback了：", cause);
        throw new NoFallbackAvailableException("哎哟，大白有点菜掉粉了呢", cause);
    }
}


