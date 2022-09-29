package com.msa.redis.demo.sbdata;

import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * 在redis中使用命令行：PUBLISH PUBLIC_TOPIC_WEB Hello 发布订阅通知
 */
@Component("PUBLIC_TOPIC_WEB")
public class RedisWebPublicChannelReceiver extends MessageListenerAdapter {

    public void handleMessage(String message) {

        System.out.println("Message: "+message);
    }

}
