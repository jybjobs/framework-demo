package com.sma.sboot.demo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("demo-service")
public interface DemoService {


    @RequestMapping("/test")
    String test();
}
