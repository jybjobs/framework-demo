package com.msa.redis.demo.sbdata;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {
   @Resource
   private RedisTemplate redisTemplate;

   @Resource
   private RedisService service;

   @Autowired
   private Publisher publisher;

   @RequestMapping("/redis/setAndGet")
   @ResponseBody
   public Map setAndGetValue(String name, String value){
      System.out.println( "name="+ name + ",value=" + value );
      redisTemplate.opsForValue().set(name,value);
      Map result = new HashMap();
      String getValue =  (String) redisTemplate.opsForValue().get(name);
      result.put(name ,getValue);
      return result;
   }

   @RequestMapping("/redis/setAndGet2")
   @ResponseBody
   public Map setAndGetValueV2(String name,String value){
      // 设置值
      service.set(name,value);
      Map result = new HashMap();
      // 发布消息
      publisher.publish("PUBLIC_TOPIC_WEB",name+":"+value);
      //查询
      String getValue =  service.get(name).toString();
      result.put(name ,getValue);
      return result;
   }
} 