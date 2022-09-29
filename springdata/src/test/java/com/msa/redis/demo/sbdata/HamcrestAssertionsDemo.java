package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.IsNaN.notANumber;

class HamcrestAssertionsDemo {
    @Test
    void assertWithHamcrestMatcher() {

        // jupiter
        Assertions.assertEquals(NaN, Math.sqrt(-1));
        // Hamcrest
        assertThat(Math.sqrt(-1), is(notANumber()));
    }

}
 