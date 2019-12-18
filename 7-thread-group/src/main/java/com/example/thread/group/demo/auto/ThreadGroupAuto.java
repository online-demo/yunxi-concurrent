package com.example.thread.group.demo.auto;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-06-16 21:00
 * @Description:
 */
public class ThreadGroupAuto {
    public static void main(String[] args) {
        print();
        // 没有指定线程组，那么自动归到当前线程所属的线程组中
        ThreadGroup group = new ThreadGroup("新的组");
        print();
    }

    private static void print() {
        Thread currentThread = Thread.currentThread();
        System.out.println("当前线程：" + currentThread.getName()
                + ", 所属线程组：" + currentThread.getThreadGroup().getName()
                + ", 线程组中有线程组数量：" + currentThread.getThreadGroup()
                .activeGroupCount()
                + ", 线程组名为：" + currentThread.getThreadGroup()
                .getName());
    }
}
