package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

@ExtendWith(TimingExtension.class)
class TimeoutDemo {
    @BeforeEach
    @Timeout(100)
    void setUp() {
        // fails if execution time exceeds 5 seconds
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void timeoutTest() throws InterruptedException {
        // fails if execution time exceeds 500 milliseconds
        Thread.sleep(400);
    }
}