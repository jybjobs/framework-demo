package com.sma.demo.mbean;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Author: jinyb
 * @Date: 2022/5/12
 * @Description: 自定义健康检查项
 * @link http://localhost:9998/monitor/health
 */
@Component
public class SelfHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                .withDetail("jvm","up")
                .build();
    }
}
