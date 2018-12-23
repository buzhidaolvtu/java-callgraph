package org.opensource.analysis.algorithms;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子命令性能评估
 * 1亿累加：
 * atom：620ms
 * 普通（带寄存器优化）：7ms，差距88倍
 */
public class CasPerformance {

    public static void main(String[] args) {
        test();
        long start = System.currentTimeMillis();
        AtomicInteger atom = new AtomicInteger();
        for (int i = 0; i < 10000 * 10000; i++) {
            atom.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        test();
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
}
