package com.sma.demo.mbean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: jinyb
 * @Date: 2022/5/11
 * @Description: Mbean扩展
 */

@Service
@ManagedResource
public class SelfMBean {

    private LongAdder counter = new LongAdder();;

    @ManagedOperation
    public long getCount(){
        return  counter.longValue();
    }

    @ManagedAttribute
    public void timer(){
        counter.increment();
    }


}
