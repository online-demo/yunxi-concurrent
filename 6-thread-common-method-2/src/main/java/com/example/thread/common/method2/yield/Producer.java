package com.example.thread.common.method2.yield;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-06-09
 * @Description: 生产者
 */
public class Producer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("I am Producer : Produced Item " + i);
//            Thread.yield();
        }
    }
}
