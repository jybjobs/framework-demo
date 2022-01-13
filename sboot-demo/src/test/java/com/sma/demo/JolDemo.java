package com.sma.demo;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class JolDemo {


    volatile long[] arr = new long[8];


    public static void main(String[] args) {
        int l = 100;
        System.out.println("int instance size:"+ClassLayout.parseInstance(l).instanceSize());

        DemoEntity o = new DemoEntity();
        o.setName("xiaoming");
        o.setId(123);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("sleep :"+ClassLayout.parseInstance(o).toPrintable());

        synchronized(o){
            System.out.println("synchronized :"+ClassLayout.parseInstance(o).toPrintable());
        }
    }
   // @Test
    public void ObjectLayoutTest() {
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        synchronized(o){
//            System.out.println("synchronized :"+ClassLayout.parseInstance(o).toPrintable());
//        }
//        Map map = new HashMap<>();//default 48
//        map.put("01","123");
//        map.put("02","123");
//        map.put("03","123");
//        map.put("04","123");
//        System.out.println("Object instance size (bytes):"+ClassLayout.parseInstance(map).instanceSize());
    }

    public void unsafeTest(){
        //Unsafe
        //AtomicInteger
    }
}
