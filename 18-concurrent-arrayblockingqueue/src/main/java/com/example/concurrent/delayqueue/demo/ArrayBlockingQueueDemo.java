package com.example.concurrent.delayqueue.demo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-02 10:19
 * @Description: ArrayBlockingQueue使用
 */
public class ArrayBlockingQueueDemo {
    /**
     * 容量
     */
    static int capacity = 10;
    /**
     * @param args
     */
    public static void main(String[] args) {

        ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<>(capacity);

        new Thread(new Producer(queue), "生产者1").start();
        new Thread(new Producer(queue), "生产者2").start();
        new Thread(new Consumer(queue), "消费者1").start();
        new Thread(new Consumer(queue), "消费者2").start();
        new Thread(new Consumer(queue), "消费者3").start();
    }

}
