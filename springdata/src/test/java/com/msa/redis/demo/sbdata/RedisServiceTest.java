package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("RedisService test class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RedisServiceTest {
    RedisTemplate redisTemplate = mock(RedisTemplate.class);
    ValueOperations valueOperations = mock(ValueOperations.class);
    RedisService redisService;

    @BeforeAll
    void before(){
        if(redisService == null){
            redisService = new RedisService();
        }
        redisService.setRedisTemplate(redisTemplate);
    }

    @Test
    @Order(1)
    void get() {
        //stub 桩单元
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("aa")).thenReturn("123");
        /**
         * Driver 驱动单元
         */
        Object value = redisService.get("aa"); //被测单元
        assertEquals("123",value);
        // hamcrest: 可读写性更强
        assertThat(value,equalTo("123"));
    }

    @Test
    @Order(2)
    void exists() {
        when(redisTemplate.hasKey("aa")).thenReturn(true);
        assertTrue(redisService.exists("aa"));
    }
}