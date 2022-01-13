package com.sma.demo.classloader;

import java.lang.reflect.Method;

public class CLDemo {

    public static void main(String[] args) {
        try {
            //1. 创建自定义类加载器的实例，可以使用上面的自定义类加载器
            SelfClassLoader loader = new SelfClassLoader("D:\\workspace\\github\\sboot-demo\\target\\test-classes");
            //2. 加载指定的类
            Class clazz = loader.findClass("com.sma.demo.DemoEntity");
            //3. 创建运行时类的实例
            Object demo = clazz.newInstance();
            //4. 获取运行时类中指定的方法
            Method m = clazz.getMethod("getId");
            //5. 调用指定的方法
            m.invoke(demo);
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("not find"+e);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
}
