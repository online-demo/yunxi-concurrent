package com.example.thread.priority.demo.extend;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-05-29
 * @Description: 线程优先级的继承特性demo
 */
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println("once Main Thread Priority = " + Thread.currentThread().getPriority());
        //待会打开下面注释再看结果
        Thread.currentThread().setPriority(10);
        System.out.println("twice Main Thread Priority = " + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
