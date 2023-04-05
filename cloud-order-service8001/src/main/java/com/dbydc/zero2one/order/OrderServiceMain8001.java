package com.dbydc.zero2one.order;

import com.dbydc.zero2one.common.config.FeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Order订单服务引导类
 * @author 大白有点菜
 * @className OrderServiceMain8001
 * @date 2023-04-01
 * @description
 * @since 1.0
 **/
@SpringBootApplication
@MapperScan("com.dbydc.zero2one.order.dao")
//@EnableFeignClients(defaultConfiguration = FeignConfig.class) //全局配置Feign
@EnableFeignClients
public class OrderServiceMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain8001.class, args);
    }
}
