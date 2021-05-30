package com.sma.sboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

//@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.sma")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootDemoApplication.class)
//                .web(WebApplicationType.NONE)
                .run(args);
    }

}
