package com.sma.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        //Runtime.getRuntime().addShutdownHook(new Thread());

        ExecutorService executor = Executors.newScheduledThreadPool(10000);

        /**
         *  public static ExecutorService newSingleThreadExecutor() {
         *         return new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         *     }
         */
        //Executors.newFixedThreadPool()
        /**
         *  public static ExecutorService newFixedThreadPool(int nThreads) {
         *         return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *     }
         */
        //Thread
        for (int i=0;i<=1000;i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        System.out.println("Runner:threadId="+Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
    }

}
