package com.example.thread.creation.demo.runnable;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-05-13
 * @Description: Runnable接口创建线程
 */
public class HelloWorldRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Concurrent World");
    }

    public static void main(String[] args) {
        System.out.println("--------实现Runnable接口--------");
        HelloWorldRunnable helloWorldRunnable = new HelloWorldRunnable();
        System.out.println("--------创建线程--------");
        Thread thread = new Thread(helloWorldRunnable);
        System.out.println("--------启动线程--------");
        thread.start();

    }
}
