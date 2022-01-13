package com.sma.demo;

public class Singleton {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // DCL（Double Checking Locking)
        if (singleton == null) {
            synchronized (Singleton.class) {       // 1
                if (singleton == null) {       // 2
                    singleton = new Singleton();      // 3
                }
            }
        }
        return singleton;
    }
}
