package com.dbydc.zero2one.order;

//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Order订单服务引导类
 * @author 大白有点菜
 * @className OrderServiceMain8003
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class OrderServiceMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain8003.class, args);
    }
}
