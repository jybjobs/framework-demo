package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class RedisService2Test {
    //RedisTemplate redisTemplate = mock(RedisTemplate.class);
    //ValueOperations valueOperations = mock(ValueOperations.class);
    @InjectMocks
    RedisService redisService;

    @Mock
    ValueOperations valueOperations;

    @Mock
    RedisTemplate redisTemplate;


    @BeforeEach
    void before(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
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
    void exists() {
        when(redisTemplate.hasKey("aa")).thenReturn(true);
        assertTrue(redisService.exists("aa"));
    }
}