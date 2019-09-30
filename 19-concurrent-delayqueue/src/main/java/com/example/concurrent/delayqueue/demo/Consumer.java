package com.example.concurrent.delayqueue.demo;

import java.util.concurrent.DelayQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-08 10:33
 * @Description: 消费者
 */
public class Consumer implements Runnable {
    private final DelayQueue<Data> queue;

    public Consumer(DelayQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Data data = queue.take();
                System.out.println(Thread.currentThread().getName() + ": take " + data);

                Thread.yield();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
