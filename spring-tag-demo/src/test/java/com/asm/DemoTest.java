package com.asm;

import com.asm.demo.tag.Reference;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-demo.xml");
        Reference reference = (Reference) context.getBean("demo");
        System.out.printf("reference="+reference.toString());
        Assert.assertNotNull(reference);
        Assert.assertEquals(reference.getProtocol(),"rmi");
    }
}
