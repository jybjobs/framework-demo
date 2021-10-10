package com.sma.mvn.service;

public class DemoServiceImpl implements DemoService {

    public String test() {
        return "demo service test method.";
    }

    /**
     *  x + y
     * @param x
     * @param y
     * @return
     */
    public int add(int x, int y) {
        return x+y;
    }

}
