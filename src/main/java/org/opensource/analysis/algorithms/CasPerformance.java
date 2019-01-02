package org.opensource.analysis.algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子命令性能评估
 * 1亿累加：
 * atom：620ms
 * 普通（带寄存器优化）：7ms，差距88倍
 */
public class CasPerformance {


    public static void main(String[] args) throws InterruptedException {
//        test();
//        long start = System.currentTimeMillis();
//        AtomicInteger atom = new AtomicInteger();
//        for (int i = 0; i < 10000 * 10000; i++) {
//            atom.incrementAndGet();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start + "ms");
//        test();
        test2();
//        test3();
        test4();
    }

    public static void test() {
        long start = System.currentTimeMillis();
        long local = 0;
        for (int i = 0; i < 10000 * 10000; i++) {
            ++local;
        }
        long end = System.currentTimeMillis();
        System.out.println(local);
        System.out.println(end - start + "ms");
    }

    /**
     *
     */
    public static void test2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(64);
        LongAdder base = new LongAdder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000 * 10000; i++) {
            executorService.submit(base::increment);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("LongAdder ：" + (end - start));
    }

    public static void test3() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        AtomicInteger base = new AtomicInteger();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000 * 10000; i++) {
            executorService.submit(base::incrementAndGet);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("AtomicInteger ：" + (end - start));
    }

    public static void test4() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(64);
        AtomicLong base = new AtomicLong();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000 * 10000; i++) {
            executorService.submit(base::incrementAndGet);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("AtomicLong ：" + (end - start));
    }
}
