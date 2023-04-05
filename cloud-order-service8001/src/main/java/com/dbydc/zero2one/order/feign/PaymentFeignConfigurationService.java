package com.dbydc.zero2one.order.feign;

import com.dbydc.zero2one.common.config.FeignConfig;
import com.dbydc.zero2one.common.utils.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign远程调用Payment服务接口（使用自定义的配置类）
 * @author 大白有点菜
 * @className PaymentFeignConfigurationService
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Service
@FeignClient(value = "cloud-payment-service", url = "localhost:6002/payment",
        contextId = "PaymentFeignConfigurationService", configuration = {FeignConfig.class})
public interface PaymentFeignConfigurationService {
    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/feign/queryByOrderNum/{orderNum}")
    ResponseData queryByOrderNum(@PathVariable("orderNum") String orderNum);
}
