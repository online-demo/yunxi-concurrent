package com.example.thread.priority.demo.daemon;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-06-03
 * @Description:    守护线程
 */
public class MyDaemon implements Runnable {
    @Override
    public void run() {
        for (long i = 0; i < 10; i++) {
            System.out.println("守护线程第" + i + "次执行！");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
