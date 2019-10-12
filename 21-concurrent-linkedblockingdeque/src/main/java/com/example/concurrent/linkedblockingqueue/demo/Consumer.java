package com.example.concurrent.linkedblockingqueue.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-18 10:22
 * @Description:  消费者
 */
public class Consumer extends Thread {

    /**
     * 需要执行的数据的引用。
     */
    private Exchanger exchanger;

    public Consumer(Exchanger exchanger, String name) {
        super(name);
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            String message;
            try {
                while ((message = exchanger.consume()) != null) {
                    System.out.printf("消费者线程%s消费数据%s%n",
                            Thread.currentThread().getName(), message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
