package com.sma.demo.mbean;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.jmx.annotation.JmxEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/**
 * @Author: jinyb
 * @Date: 2022/5/12
 * @Description:
 */
@Component
@Endpoint(id = "self",enableByDefault = true)  // = @WebEndpoint + @JmxEndpoint
public class SelfEndpoint {
   private static final String DESIRE = "I hope the epidemic will pass soon.";

    /**
     * 会显示在 org.springframework.boot.Endpoint.self 下
     * @return
     */
   @ReadOperation
   public String getInfo(){
       return DESIRE;
   }


}
