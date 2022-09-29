package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.springframework.test.util.AssertionErrors.fail;
/**
 * 单元测试类
 */
@DisplayName("A special test case")
class StandardTests {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
    class SubStandardTests{

    }
    @BeforeAll
    static void initAll() {}

    @BeforeEach
    void init() {}

    @Test
    void succeedingTest() {}

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {}

    @AfterAll
    static void tearDownAll() {}
}