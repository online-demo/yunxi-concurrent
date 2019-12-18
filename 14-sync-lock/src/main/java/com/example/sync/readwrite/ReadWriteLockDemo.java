package com.example.sync.readwrite;
import org.jetbrains.annotations.NotNull;

import	java.util.Date;
import	java.text.SimpleDateFormat;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-19 20:05
 * @Description: ReadWriteLock可重入读写锁
 */
public class ReadWriteLockDemo {
    public static final int COUNT = 5;
    /**
     * 可重入读写锁
     */
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    /**
     * 写锁
     */
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    /**
     * 处理读操作
     */
    private void handleRead(@NotNull ReentrantReadWriteLock.ReadLock lock) throws InterruptedException {
        try {
            // 模拟读操作
            lock.lock();
            System.out.println(printDate() + " 读锁执行了。。。");
            // 读操作的耗时越多，读写锁的性能优势就越明显
            Thread.sleep(5000);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 处理写操作
     */
    private void handleWrite(@NotNull ReentrantReadWriteLock.WriteLock lock, int index) throws InterruptedException {
        try {
            // 模拟写操作
            lock.lock();
            System.out.println(printDate() + " 写锁执行了。。。");
            Thread.sleep(5000);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = () -> {
            try {
                demo.handleRead(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = () -> {
            try {
                demo.handleWrite(writeLock, new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // ！！！最好使用线程池管理线程！！！
        for (int i = 0; i < COUNT * 2; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 0; i < COUNT; i++) {
            new Thread(writeRunnable).start();
        }
    }

    private String printDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date());
    }
}
