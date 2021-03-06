package com.example.thread.stop.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-05-27
 * @Description:    设置退出标识
 */
public class FlagThread extends Thread {
    /**
     * 退出标识
     */
    public volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit);
        System.out.println("ThreadFlag线程退出");
    }

    public static void main(String[] args) throws Exception
    {
        FlagThread threadFlag = new FlagThread();
        threadFlag.start();
        // 主线程延迟3秒
        sleep(3000);
        // todo 终止线程thread
        threadFlag.exit = true;
        // main线程放弃cpu使用权
        // 让threadFlag线程继续执行，直到threadFlag运行完
        threadFlag.join();
        System.out.println("线程退出!");
    }
}
