package com.example.concurrent.delayqueue.demo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-02 10:20
 * @Description: 消费者
 */
public class Consumer implements Runnable {

    /**
     * 容器
     */
    private final ArrayBlockingQueue<Bread> queue;

    /**
     * 构造器
     */
    public Consumer(ArrayBlockingQueue<Bread> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < ArrayBlockingQueueDemo.capacity * ArrayBlockingQueueDemo.capacity; i++) {
            consume();
        }
    }

    public void consume() {
        /**
         * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
         * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
         */
        try {
            Bread bread = queue.take();
            System.out.println(Thread.currentThread().getName() + " 消费面包:" + bread);
//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
