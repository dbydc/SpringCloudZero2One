package com.dbydc.zero2one.payment;

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
 * 测试类1
 * @author 大白有点菜
 * @className Zero2OneTest1
 * @date 2023-04-01
 * @description
 * @since 1.0
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class Zero2OneTest1 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        //System.out.println("大白有点菜");
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
