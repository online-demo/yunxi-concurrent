package com.example.concurrent.synchronize.demo;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-12-16 20:05
 * @Description: SynchronizeQueue使用方式
 */
public class SynchronizeQueueTest {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        int count = 10;
        Thread producer = new Thread(() -> {
            System.out.println("生产者线程启动");
            try {
                for (int i = 0; i < count; i++) {
                    queue.put(i);
                    System.out.println("生产者线程生产元素: " + i);
                }
            } catch (InterruptedException e) {
            }
            System.out.println("生产者线程结束");
        });

        Thread consumer = new Thread(() -> {
            System.out.println("消费者线程启动");
            try {
                for (int i = 0; i < count; i++) {
                    System.out.println("消费者线程获取元素: " + queue.take());
                }
            } catch (InterruptedException e) {
            }
            System.out.println("消费者线程结束");
        });

        producer.start();
        Thread.sleep(1000);
        consumer.start();
    }
}
