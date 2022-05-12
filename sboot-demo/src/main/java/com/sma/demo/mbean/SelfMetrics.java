package com.sma.demo.mbean;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: jinyb
 * @Date: 2022/5/12
 * @Description: 自定义metrics指标采集器
 * @link http://localhost:9998/monitor/metrics/http.requests
 * {
 * name: "http.requests",
 * description: null,
 * baseUnit: null,
 * measurements: [
 * {
 * statistic: "COUNT",
 * value: 4
 * }
 * ],
 * availableTags: [
 * {
 * tag: "uri",
 * values: [
 * "/trans"
 * ]
 * }
 * ]
 * }
 *
 */

@Component
public class SelfMetrics  {

    @Autowired
    private MeterRegistry meterRegistry;


    /**
     * @Description // 调用次数统计
     * @Param []
     * @return void
     **/
    public void timer(){
        meterRegistry.counter("http.requests","uri","/trans").increment();
    }

}
