package com.example.concurrent.linkedblockingqueue.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-18 09:53
 * @Description:  LinkedBlockingDeque使用
 */
public class LinkedBlockingDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        Exchanger stack = new Exchanger();
        Producer producer = new Producer(stack, "Producer1");
        Consumer consumer = new Consumer(stack, "Consumer1");
        //向栈中循环添加数据。
        producer.start();
        //打印所有的栈的数据。
        consumer.start();
        Thread.sleep(5000);
        producer.setStop(true);
    }
}
