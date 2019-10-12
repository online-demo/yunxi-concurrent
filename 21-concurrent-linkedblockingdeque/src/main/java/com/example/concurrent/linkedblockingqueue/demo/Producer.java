package com.example.concurrent.linkedblockingqueue.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-18 11:03
 * @Description:  生产者
 */
public class Producer extends Thread {

    /**
     * 是否结束运行。
     */
    private volatile boolean stop;
    /**
     * 自增编号。
     */
    private AtomicInteger sequence = new AtomicInteger(1);

    /**
     * 需要执行的数据的引用。
     */
    private Exchanger exchanger;

    public Producer(Exchanger exchanger, String name) {
        super(name);
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        while (!stop) {

            try {
                Thread.sleep(500);
                String message = String.valueOf(sequence.getAndIncrement());
                this.exchanger.produce(message);
                System.out.printf("生产者线程%s生产数据%s%n",
                        Thread.currentThread().getName(), message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
