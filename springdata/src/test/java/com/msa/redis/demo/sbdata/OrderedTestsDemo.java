package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class OrderedTestsDemo {
    @Test
    @Order(1)
    @DisplayName("order 1")
    void nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(2)
    @DisplayName("order 2")
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    @DisplayName("order 3")
    void validValues() {
        // perform assertions against valid values
    }
}
