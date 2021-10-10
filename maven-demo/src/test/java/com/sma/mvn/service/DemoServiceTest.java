package com.sma.mvn.service;


import org.junit.Assert;
import org.junit.Test;

public class DemoServiceTest {


    @Test
    public void add(){
            DemoService demoService = new DemoServiceImpl();
            int result = demoService.add(1,1);
        Assert.assertEquals("1+1=2",result,2);

    }
}
