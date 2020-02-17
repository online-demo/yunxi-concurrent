package com.example.concurrent.linkedblockingqueue.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-10 06:53
 * @Description: LinkedBlockingQueue实现生产者-消费者模型
 */
public class LinkedBlockingQueueTest {
    /**
     * 生产者生产的消息。
     */
    private static AtomicInteger PRODUCE_COUNT = new AtomicInteger(0);
    /**
     * 消费者消费的消息。
     */
    private static AtomicInteger CONSUME_COUNT = new AtomicInteger(0);
    /**
     * 阻塞队列。
     */
    private static LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
    /**
     * 生产者-消费者模型传递的消息总数。
     */
    private static final int COUNT = 20;

    /**
     * 生产者线程。
     */
    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                try {
                    Integer messageId = PRODUCE_COUNT.incrementAndGet();
                    linkedBlockingQueue.put(messageId);
                    System.out.printf("%s生产的消息id=%s，队列剩余容量=%s%n", Thread.currentThread().getName(),
                            messageId, linkedBlockingQueue.remainingCapacity());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者线程。
     */
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (CONSUME_COUNT.get() < COUNT) {
                try {
                    // 带超时时间的出队方法，如果不存在将返回null。
                    Integer messageId = linkedBlockingQueue.poll(5, TimeUnit.SECONDS);
                    System.out.printf("%s消费的消息id=%s，队列剩余容量=%s%n", Thread.currentThread().getName(),
                            messageId, linkedBlockingQueue.remainingCapacity());
                    CONSUME_COUNT.incrementAndGet();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 推荐使用ThreadPoolExecutor创建线程。
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Consumer(), "消费者2").start();
        new Thread(new Consumer(), "消费者3").start();
    }
}