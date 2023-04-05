package com.dbydc.zero2one.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Payment支付服务引导类
 * @author 大白有点菜
 * @className PaymentServiceMain6002
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@SpringBootApplication
@MapperScan("com.dbydc.zero2one.payment.dao")
public class PaymentServiceMain6002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceMain6002.class, args);
    }
}
