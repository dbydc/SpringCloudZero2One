package com.dbydc.zero2one.payment.config;

import com.dbydc.zero2one.payment.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebMvc拦截器配置类
 * @author 大白有点菜
 * @className WebMvcConfig
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }
}
