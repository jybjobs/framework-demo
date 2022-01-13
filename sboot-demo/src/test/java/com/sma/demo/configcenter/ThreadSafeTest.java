package com.sma.demo.configcenter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeTest {

    String getDBTarget(String tenantId,String userId) {
         Map<String, String> map = ConfigsUtils.transformTenantParam(tenantId, userId);
         return map.getOrDefault("tenantId","default");
    }

    public static void main(String[] args) {
        ThreadSafeTest test = new ThreadSafeTest();
        ExecutorService executor = Executors.newFixedThreadPool(40);
        CountDownLatch latch = new CountDownLatch(100000);
        for (int i=0;i<=100000;i++) {
            final int ii = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    String tenantId = test.getDBTarget(String.valueOf(100+ii),String.valueOf(999+ii));
                    if(!String.valueOf(100+ii).equals(tenantId)) {
                        System.out.println("Runner:threadId=" + (100 + ii) + ",tenantId=" + tenantId);
                    }
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
            //Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            executor.shutdown();
        }
    }

}
