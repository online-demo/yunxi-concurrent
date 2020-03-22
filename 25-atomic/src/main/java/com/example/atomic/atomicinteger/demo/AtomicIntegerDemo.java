package com.example.atomic.atomicinteger.demo;
import	java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2020-03-21 16:20
 * @Description: AtomicInteger使用方式
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }

    private static void test1() throws InterruptedException {
        Counter counter = new Counter();
        // 10个线程
        for (int i = 0; i < 10; i++) {
            // 每个线程对count累加1000次
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.addCount();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("count = " + counter.getCount());
    }

    private static void test2() throws InterruptedException {
        /**
         * 原子性的int
         */
        AtomicInteger count = new AtomicInteger();
        // 10个线程
        for (int i = 0; i < 10; i++) {
            // 每个线程对count累加1000次
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    count.incrementAndGet();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("count = " + count.get());
    }
}
