package com.sma.demo;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * atomicLong 和 LongAdder的性能对比
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Threads(4)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 2, time = 5)
@State(Scope.Benchmark)
public class CasVsAdder {
    private AtomicLong count;
    private LongAdder adder;

    @Setup
    public void init() {
        count = new AtomicLong(0);
        adder = new LongAdder();
    }


    @Benchmark
    public void testCas() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }


    @Benchmark
    public void testAdder() {
        for (int i = 0; i < 10000; i++) {
            adder.increment();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(CasVsAdder.class.getSimpleName())
                .output(System.getProperty("user.home") + "/" + CasVsAdder.class.getSimpleName()
                        + ".txt")
                .build();
        new Runner(options).run();
    }
}