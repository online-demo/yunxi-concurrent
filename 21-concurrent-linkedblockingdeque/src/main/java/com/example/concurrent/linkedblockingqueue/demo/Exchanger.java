package com.example.concurrent.linkedblockingqueue.demo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-18 09:55
 * @Description: 数据交换方法
 */
public class Exchanger {

    /**
     * 用于保存数据的仓库
     */
    private LinkedBlockingDeque<String> buffer;

    public Exchanger() {
        this.buffer = new LinkedBlockingDeque<>(1);
    }

    /**
     * 向栈中添加数据
     */
    public void produce(String message) throws InterruptedException {
        buffer.put(message);
    }

    /**
     * 获取栈中的数据，如果没有数据就返回null.
     */
    public String consume() throws InterruptedException {
        return this.buffer.poll(1000, TimeUnit.MILLISECONDS);
    }

}
