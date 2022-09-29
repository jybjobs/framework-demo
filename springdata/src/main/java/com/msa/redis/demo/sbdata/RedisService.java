package com.msa.redis.demo.sbdata;
 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*; 
import org.springframework.stereotype.Service; 
 
import java.io.Serializable; 
import java.util.List; 
import java.util.Set; 
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;

@Service 
public class RedisService {
   private static  final Logger logger = LoggerFactory.getLogger(RedisService.class);
   @Autowired 
   private RedisTemplate redisTemplate;

   public boolean set(final String key, Object value) {
      boolean result = false;
      try {
         ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
         operations.set(key, value);
         result = true;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }

   public boolean set(final String key, Object value, Long expireTime) {
      boolean result = false;
      try {
         ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
         operations.set(key, value);
         redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
         result = true;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }
   public void remove(final String... keys) {
      for (String key : keys) {
         remove(key);
      }
   }

   public void remove(final String key) {
      if (exists(key)) {
         redisTemplate.delete(key);
      }
   }
   public boolean exists(final String key) {
      logger.debug("method exists,key={}",key);
      return redisTemplate.hasKey(key);
   }

   public Object get(final String key) {
      logger.debug("method get,key={}",key);
      Object result = null;
      ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
      result = operations.get(key);
      return result;
   }
   public void hmSet(String key, Object hashKey, Object value) {
      HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
      hash.put(key, hashKey, value);
   }

   public Object hmGet(String key, Object hashKey) {
      HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
      return hash.get(key, hashKey);
   }
   public void lPush(String k, Object v) {
      ListOperations<String, Object> list = redisTemplate.opsForList();
      list.rightPush(k, v);
   }
   public List<Object> lRange(String k, long l, long l1) {
      ListOperations<String, Object> list = redisTemplate.opsForList();
      return list.range(k, l, l1);
   }
   public void add(String key, Object value) {
      SetOperations<String, Object> set = redisTemplate.opsForSet();
      set.add(key, value);
   }
   public Set<Object> setMembers(String key) {
      SetOperations<String, Object> set = redisTemplate.opsForSet();
      return set.members(key);
   }

   // 添加有序集合
   public void zAdd(String key, Object value, double scoure) {
      ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
      zset.add(key, value, scoure);
   }
   public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
      ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
      redisTemplate.opsForValue();
      return zset.rangeByScore(key, scoure, scoure1);
   }


   public void setRedisTemplate(RedisTemplate redisTemplate) {
      this.redisTemplate = redisTemplate;
   }
}