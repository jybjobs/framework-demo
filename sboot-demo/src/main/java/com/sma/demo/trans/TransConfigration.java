package com.sma.demo.trans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransConfigration {

    @Value("${trans.baidu.appid}")
    private String appid;
    @Value("${trans.baidu.securityKey}")
    private String securityKey;

    @Bean
    public TransApi getTransApi() {
        return new TransApi(appid,securityKey);
    }
}
