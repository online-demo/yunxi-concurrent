package com.example.thread.interruption.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-05-18
 * @Description: 捕获异常并重新抛出
 */
public class RethrowInterrupterException {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        try {
            thread.interrupt();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("做一些清理工作");
            throw e;
        }
    }

}
