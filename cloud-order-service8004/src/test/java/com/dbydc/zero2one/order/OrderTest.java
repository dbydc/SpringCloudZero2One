package com.dbydc.zero2one.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Order测试类
 * @author 大白有点菜
 * @className OrderTest
 * @date 2023-04-06
 * @description
 * @since 1.0
 **/
@SpringBootTest
@Slf4j
public class OrderTest {

    @Value("${server.port}")
    private String serverPort;

    @Value("${blogger}")
    private String blogger;

    @Value("${use.configurationFile}")
    private String configurationFile;

    @Test
    public void contextLoads() {
        //log.warn("嘿，" + blogger + "，应用程序的端口号：" + serverPort + " ，优先使用的配置文件：" + configurationFile);
        log.warn("嘿，{}，应用程序的端口号：{}，优先使用的配置文件：{}", blogger, serverPort, configurationFile);
    }
}
