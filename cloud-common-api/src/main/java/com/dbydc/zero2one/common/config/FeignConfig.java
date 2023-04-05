package com.dbydc.zero2one.common.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * 公共OpenFeign远程调用配置类
 * @author 大白有点菜
 * @className FeignConfig
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
public class FeignConfig {

    long connectTimeout = 5L;
    long readTimeout = 5L;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, TimeUnit.SECONDS, readTimeout, TimeUnit.SECONDS, true);
    }

    /**
     * 日志级别
     * 1、NONE：无日志记录（默认）。
     * 2、BASIC：只记录请求方法（request method）、URL、响应状态码（response status code）和执行时间（execution time）。
     * 3、HEADERS：记录基本信息（在BASIC级别基础上）以及请求和响应标头（headers）。
     * 4、FULL：记录请求和响应的标头（headers）、正文（body）和元数据（metadata）。
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
