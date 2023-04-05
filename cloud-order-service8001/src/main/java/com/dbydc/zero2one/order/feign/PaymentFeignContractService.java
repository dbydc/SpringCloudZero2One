package com.dbydc.zero2one.order.feign;

import com.dbydc.zero2one.common.config.FeignConfig;
import com.dbydc.zero2one.common.config.FeignContractConfig;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * Feign远程调用Payment服务接口（主要是演示契约配置）
 * @author 大白有点菜
 * @className PaymentFeignContractService
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Service
@FeignClient(value = "cloud-payment-service", url = "localhost:6002/payment",
        contextId = "PaymentFeignContractService", configuration = {FeignConfig.class, FeignContractConfig.class})
public interface PaymentFeignContractService {
    /**
     * 演示契约配置（FeignContractConfig配置文件）
     * 1、Contract.Default()：Feign 原生默认契约，不支持SpringMvc注解。
     * 2、SpringMvcContract()：OpenFeign 支持SpringMvc注解。
     * @return
     */
    @RequestLine("GET /feign/contract/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    String paymentFeignContract(@Param("id") int id);
}
