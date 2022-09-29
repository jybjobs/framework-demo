package com.msa.redis.demo.sbdata;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@RunWith(SpringRunner.class)// 默认junit5，增加后按junit4执行
@SpringBootTest
@ActiveProfiles("dev")
class RedisControllerTest {

    @Autowired
    private RedisController redisController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(redisController).build();
    }

    @Test
    void setAndGetValue() {

    }

    @Test
    void setAndGetValueV2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/redis/setAndGet2")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("name","aa")
                        .param("value","123")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
       // redisController.setAndGetValueV2("aa","123");
    }
}