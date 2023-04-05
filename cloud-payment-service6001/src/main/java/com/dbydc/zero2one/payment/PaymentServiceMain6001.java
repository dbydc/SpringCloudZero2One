package com.dbydc.zero2one.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Payment支付服务引导类
 * @author 大白有点菜
 * @className PaymentServiceMain6001
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
@SpringBootApplication
@MapperScan("com.dbydc.zero2one.payment.dao")
public class PaymentServiceMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceMain6001.class, args);
    }
}
