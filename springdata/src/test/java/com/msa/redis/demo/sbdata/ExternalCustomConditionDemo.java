package com.msa.redis.demo.sbdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

class ExternalCustomConditionDemo {
    @Test
    @EnabledIf("com.msa.redis.demo.sbdata.ExternalCondition#customCondition")
    void enabled() {
// ...
    }
}

class ExternalCondition {
    static boolean customCondition() {
        return true;
    }
}