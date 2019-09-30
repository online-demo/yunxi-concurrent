package com.example.concurrent.delayqueue.demo;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-08 11:10
 * @Description: 生产者
 */
public class Producer implements Runnable {
    private final DelayQueue<Data> queue;

    public Producer(DelayQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {

            long currentTime = System.nanoTime();
            long validTime = ThreadLocalRandom.current().nextLong(1000000000L, 7000000000L);

            Data data = new Data(currentTime + validTime);
            queue.put(data);

            System.out.println(Thread.currentThread().getName() + ": put " + data);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
