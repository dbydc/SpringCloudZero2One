package com.dbydc.zero2one.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * MyTest类
 * @author 大白有点菜
 * @className MyTest
 * @date 2023-04-01
 * @description
 *      如果包路径是（com.dbydc.zero2one.test），和 main 目录的包路径（假设是 com.dbydc.zero2one.payment）不一样，
 *      是无法调用 Controller 的接口。
 * @since 1.0
 **/
@SpringBootTest(classes = MyTest.class)
@AutoConfigureMockMvc
public class MyTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        //无法请求到 Controller 的接口
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/payment/queryByOrderNum/{orderNum}", "dbydc666")
//                MockMvcRequestBuilders.get("/payment/queryByOrderNum")
//                    .param("orderNum", "dbydc666")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
