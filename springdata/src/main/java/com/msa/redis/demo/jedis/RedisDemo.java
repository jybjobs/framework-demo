package com.msa.redis.demo.jedis;

import redis.clients.jedis.*;

import java.util.*;

public class RedisDemo {

    public static void main(String[] args){
        //生成一个Jedis对象，这个对象负责和指定的Redis节点进行通信
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        //jedis执行set命令
//        jedis.set("name","redis");
//        //jedis执行get命令
//        String name = jedis.get("name");
//        System.out.println(name);
//        jedis.close();
//        opsStr();
//        opsMap();
//        testList();
//        testSet();
//        testSort();
        //jedisPipelined();
        /**性能对比：
         * Transaction SET: 0.317 seconds
         * Pipelined transaction: 0.007 seconds
         */
        jedisTrans();
        jedisCombPipelineTrans();

    }

    static void opsStr(){
        // 连接Redis服务器，127.0.0.1:6379
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // -----添加数据----------
        jedis.set("name", "wang");
        System.out.println(jedis.get("name"));// 执行结果：wang

        jedis.append("name", " is my friend"); // 拼接
        System.out.println(jedis.get("name"));

        jedis.del("name"); // 删除某个key
        System.out.println(jedis.get("name"));
        // 设置多个key-value键值对
        jedis.mset("name", "xiaoming", "age", "35", "phone", "13333333333");
        jedis.incr("age"); // 进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" +
                jedis.get("phone"));
        jedis.close();
    }

    /**
     * ops command:  hget
     */
    public static void opsMap() {
        // -----添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "wang");
        map.put("age", "22");
        map.put("qq", "123456");

        // 连接Redis服务器，127.0.0.1:6379
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.hmset("user", map);
        // 取出user中的name，执行结果:[minxr]。注意，结果是一个泛型的List
        // 第一个参数是存入Redis中Map的key，后面跟的是放入Map中的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");

        // 删除Map中的某个key
        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age")); // 因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));// 是否存在key为user的记录，存在则返回true
        System.out.println(jedis.hkeys("user"));// 返回Map中的所有key
        System.out.println(jedis.hvals("user"));// 返回Map中的所有value

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
        jedis.close();
    }

    /**
     * command:
     * LRANGE "java framework" 0 10
     * LPUSH "java framework" mybatis
     */
    public static void testList() {
        // 连接Redis服务器，127.0.0.1:6379
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 开始操作前，先删除key为“java framework”的所有内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 先向key为“java framework”的列表按照从左到右的顺序存放3条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // jedis.lrange()返回列表中指定区间内的元素，其中0表示列表的第一个元素，-1表示列表的最后一个元素
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 开始操作前，先移除key为“java framework”的所有内容
        jedis.del("java framework");
        // 再向key为"java framework"的列表尾部（最右边）存放三条数据
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.close();
    }

    /**
     * command:
     * SRANDMEMBER usernames 10
     */
    public static void testSet() {
        // 连接Redis服务器，127.0.0.1:6379
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 添加元素
        jedis.sadd("usernames", "lisi","wangwu","xinping","zhangsan");
        // 获取所有加入的value
        System.out.println(jedis.smembers("usernames"));
        // 判断who是不是user集合的元素
        System.out.println(jedis.sismember("usernames", "who"));
        System.out.println(jedis.srandmember("usernames"));
        // 返回集合的元素个数
        System.out.println(jedis.scard("usernames"));
        jedis.close();
    }

    public static void testSort()   {
        // 连接Redis服务器，127.0.0.1:6379
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // Jedis排序
        // 注意，此处的rpush()和lpush()是对List的操作，是一个双向链表
        jedis.del("a");// 先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //输出排序后的结果
        System.out.println(jedis.lrange("a", 0, -1));
    }

    public static void testHyperLogLog(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        // 模拟在2020年8月6日22点，存储100万条用户访问数据
        for (int i = 0; i < 100 * 10000; i++) {
            jedis.pfadd("user:login:2020080622", "user-"+ i );
        }

        long total = jedis.pfcount("user:login:2020080622");
        System.out.printf("key=user:login:202008062200 count=%d", total);

        jedis.close();
    }

    /**
     * redis 事务：
     * Redis事务可以一次执行多个命令，有以下两个特性。
     * ·隔离性：事务的所有命令都会被序列化，按顺序执行，事务执行完后才会执行其他客户端的命令。
     * ·原子性：事务中的命令要么全部被执行，要么全部不执行。
     */
    public static void jedisTrans() {
        Jedis jedis = new Jedis("localhost");
        long start = System.currentTimeMillis();
        // 开启事务
        Transaction tx = jedis.multi();
        for (int i = 0; i < 100*1000; i++) {
            tx.set("t:" + i,  i + "");
        }

        // 提交事务
        List<Object> results = tx.exec();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
    }

    /**
     * 管道是一种两个进程之间进行单向通信的机制。
     * 在Redis中有时候我们需要采用异步的方式，一次发送多个命令，
     * 并且不同步等待其返回结果，这样可以取得非常好的执行效率。
     */
    public static  void jedisPipelined() {
        Jedis jedis = new Jedis("localhost");
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            pipeline.set("p:" + i, "" + i);
        }
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
    }

    /**
     * pipeline 中使用事务
     */
    public static  void jedisCombPipelineTrans() {
        Jedis jedis = new Jedis("localhost");
        long start = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        for (int i = 0; i < 100*000; i++) {
            pipeline.set("s:" + i, "" + i);
        }
        pipeline.exec();
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined transaction: " + ((end - start) / 1000.0) +
                " seconds");
        jedis.disconnect();
    }

    /**
     * 集群访问
     */
    public static void testJedisCluster()  {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(60000);       // 设置最大连接数
        config.setMaxIdle(1000);         // 设置最大空闲数
        config.setMaxWaitMillis(3000);   // 设置超时时间
        config.setTestOnBorrow(true);

        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.11.15", 8001));
        nodes.add(new HostAndPort("192.168.11.15", 8002));
        nodes.add(new HostAndPort("192.168.11.15", 8003));
        nodes.add(new HostAndPort("192.168.11.15", 8004));
        nodes.add(new HostAndPort("192.168.11.15", 8005));
        nodes.add(new HostAndPort("192.168.11.15", 8006));
        JedisCluster cluster = new JedisCluster(nodes, config);
        cluster.set("book", "redis");
        System.out.println("集群测试  key=book,value=" + cluster.get("book"));
        cluster.close();
    }
}