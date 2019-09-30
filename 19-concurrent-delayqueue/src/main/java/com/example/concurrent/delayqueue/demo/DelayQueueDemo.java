package com.example.concurrent.delayqueue.demo;

import java.util.concurrent.DelayQueue;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-08 12:01
 * @Description: DelayQueue使用Demo
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        DelayQueue<Data> queue = new DelayQueue<>();

        Thread c1 = new Thread(new Consumer(queue), "consumer-1");
        Thread p1 = new Thread(new Producer(queue), "producer-1");

        c1.start();
        p1.start();
    }
}
