package com.example.atomic.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2020-03-29 17:44
 * @Description: AtomicStampedReference使用方式
 */
public class AtomicStampedReferenceDemo {
    /**
     * AtomicInteger计数器
     */
    private static AtomicInteger atomicCounter = new AtomicInteger(100);
    /**
     * AtomicStampedReference计数器
     */
    private static AtomicStampedReference<Integer> atomicStampedCounter = new AtomicStampedReference<Integer>(100, 0);
    /**
     * 测试代码
     */
    public static void main(String[] args) throws InterruptedException {

        // 测试AtomicInteger不会发现ABA问题
        Thread thread1 = new Thread(() -> {
            // 100变101
            atomicCounter.compareAndSet(100, 101);
            // 101变100
            atomicCounter.compareAndSet(101, 100);
        });

        // 测试线程2不会发现ABA问题
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean atomicResult = atomicCounter.compareAndSet(100, 101);
            System.out.println("发生ABA问题时，AtomicInteger执行结果= " + atomicResult);
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // 测试AtomicStampedReference会发现ABA问题
        Thread stamped1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedCounter.compareAndSet(100, 101, atomicStampedCounter.getStamp(), atomicStampedCounter.getStamp() + 1);
            atomicStampedCounter.compareAndSet(101, 100, atomicStampedCounter.getStamp(), atomicStampedCounter.getStamp() + 1);
            System.out.println("线程stamped1获取的版本号 = " + atomicStampedCounter.getStamp());
        });

        Thread stamped2 = new Thread(() -> {
            // stamp发生变化
            int stamp = atomicStampedCounter.getStamp();
            System.out.println("线程stamped2在ABA发生前获取的版本号 = " + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean atomicStampedResult = atomicStampedCounter.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println("发生ABA问题时，AtomicStampedReference执行结果= " + atomicStampedResult);
        });

        stamped1.start();
        stamped2.start();
    }
}
