package com.example.concurrent.copyonwritearraylist.demo;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-12-25 00:15
 * @Description: CopyOnWriteArrayList使用方式
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i);
        }
        new Thread(() -> {
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "输出元素：" + copyOnWriteArrayList.get(i));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
//                try {
//                    Thread.sleep(800);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (copyOnWriteArrayList.get(i) % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "删除元素：" + copyOnWriteArrayList.remove(i));
                }
            }
        }).start();

        Thread.sleep(10000);
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println("CopyOnWriteArrayList剩余元素：" + integer);
        }
    }
}
