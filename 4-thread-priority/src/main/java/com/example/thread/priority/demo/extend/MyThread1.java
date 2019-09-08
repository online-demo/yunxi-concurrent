package com.example.thread.priority.demo.extend;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-05-29
 * @Description:
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        //输出线程级别
        System.out.println("MyThread1 Priority = " + this.getPriority());
        //启动线程MyThread2
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
