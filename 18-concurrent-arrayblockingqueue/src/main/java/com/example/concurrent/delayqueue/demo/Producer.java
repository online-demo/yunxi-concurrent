package com.example.concurrent.delayqueue.demo;

import java.util.Random;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-02 10:10
 * @Description: 生产者
 */
public class Producer implements Runnable {

    /**
     * 容器
     */
    private final ArrayBlockingQueue<Bread> queue;
    /**
     * 构造器
     */
    public Producer(ArrayBlockingQueue<Bread> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // 限量供应，饥饿营销
        for (int i = 0; i < ArrayBlockingQueueDemo.capacity * ArrayBlockingQueueDemo.capacity; i++) {
            produce();
        }
    }

    public void produce() {
        /**
         * put()方法是如果容器满了的话就会把当前线程挂起
         * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。
         */
        try {
            Random random = new Random();
            Bread bread = new Bread(random.nextInt(10));
            queue.put(bread);
            System.out.println(Thread.currentThread().getName() + "生产面包:" + bread);
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
