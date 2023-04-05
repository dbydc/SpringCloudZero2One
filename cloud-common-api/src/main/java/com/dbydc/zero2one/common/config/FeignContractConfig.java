package com.dbydc.zero2one.common.config;

import feign.Contract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

/**
 * 公共Feign契约配置类
 * @author 大白有点菜
 * @className FeignContractConfig
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
public class FeignContractConfig {

    /**
     * 契约配置
     * @return
     */
    @Bean
    Contract feignContract() {
        return new Contract.Default();  //不支持 SpringMvc 注解
//        return new SpringMvcContract(); //支持 SpringMvc 注解
    }
}
