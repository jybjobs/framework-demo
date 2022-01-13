package com.sma.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * volatile 是否为原子性的测试
 */
public class VolatileDemo
{
    private volatile long value;

    @Test
    public void testAtomicLong() {
        // 并发任务数
        final int TASK_AMOUNT = 10;

        //线程池，获取CPU密集型任务线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // 每条线程的执行轮数
        final int TURNS = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(TASK_AMOUNT);
        long start = System.currentTimeMillis();
        for (int i = 0; i < TASK_AMOUNT; i++) {
            pool.submit(() ->
            {
                try {
                    for (int j = 0; j < TURNS; j++) {
                        value++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float time = (System.currentTimeMillis() - start) / 1000F;
        //输出统计结果
        System.out.println("运行的时长为：" + time);
        System.out.println("累加结果为：" + value);
        System.out.println("与预期相差：" + (TURNS * TASK_AMOUNT - value));
    }
    }