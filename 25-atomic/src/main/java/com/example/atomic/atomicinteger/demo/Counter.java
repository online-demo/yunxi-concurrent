package com.example.atomic.atomicinteger.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2020-03-21 16:31
 * @Description: 计数器
 */
public class Counter {

    /**
     * volatile修饰的计数器
     */
    private volatile static int count = 0;

    /**
     * 不是原子性操作
     * count++可以分解为一下几个原子性的步骤：
     * 1.读取count的值
     * 2.计算新值=count+1
     * 3.新值写入count变量
     *
     * 如果步骤1，2，3中有多个线程并发执行，
     * 那么就会出现两个线程并发的执行步骤2，
     * 我们希望的两个线程依次执行加1操作
     */
    public void addCount() {
        count++;
    }

    public int getCount() {
         return count;
    }
}
