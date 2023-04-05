package com.dbydc.zero2one.order.config;

import com.dbydc.zero2one.order.interceptor.FeignAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器配置类
 * @author 大白有点菜
 * @className OrderInterceptorConfig
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Configuration
public class OrderInterceptorConfig {

    @Value("${feign.tokenId}")
    private String tokenId;

    /**
     * 自定义拦截器
     * @return
     */
    @Bean
    FeignAuthRequestInterceptor feignAuthRequestInterceptor() {
        return new FeignAuthRequestInterceptor(tokenId);
    }
}
