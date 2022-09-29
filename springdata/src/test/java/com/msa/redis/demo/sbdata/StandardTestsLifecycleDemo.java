package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.springframework.test.util.AssertionErrors.fail;

/**
 * 单元测试类
 */

class StandardTestsLifecycleDemo implements TestLifecycleLogger{

    @BeforeAll
    static void initAll() {}

    @BeforeEach
    void init() {}

    @Test
    void succeedingTest() {}


    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {}

    @AfterAll
    static void tearDownAll() {}
}