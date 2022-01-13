package com.sma.demo;

public class CounterSample {


    volatile int sum = 0;

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void increase() {
        sum++;
    }

    public static void main(String[] args) {
        CounterSample counterSample = new CounterSample();
        counterSample.setSum(100);
    }
}
