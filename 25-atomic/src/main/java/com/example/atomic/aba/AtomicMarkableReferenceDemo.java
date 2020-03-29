package com.example.atomic.aba;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2020-03-29 18:03
 * @Description: AtomicMarkableReference使用方式
 */
public class AtomicMarkableReferenceDemo {

    /**
     * 初始值
     */
    private static final Integer INIT_NUM = 10;
    /**
     * 临时值
     */
    private static final Integer TEMP_NUM = 20;
    /**
     * 更新值
     */
    private static final Integer UPDATE_NUM = 100;

    private static final Boolean INITIAL_MARK = Boolean.FALSE;

    private static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(INIT_NUM, INITIAL_MARK);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " ： 初始值为：" + INIT_NUM + " , 标记为： " + INITIAL_MARK);
            boolean mark = atomicMarkableReference.isMarked();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行CAS  10 ---> 100
            boolean result = atomicMarkableReference.compareAndSet(INIT_NUM, UPDATE_NUM, mark, Boolean.TRUE);
            System.out.println("AtomicMarkableReference发生ABA后的执行结果=" + result);
        }, "线程A").start();

        new Thread(() -> {
            Thread.yield();
            // 初始态
            System.out.println(Thread.currentThread().getName() + " ： 初始值为：" + atomicMarkableReference.getReference() + " , 标记为： " + INITIAL_MARK);
            // CAS修改  10 ---> 20
            atomicMarkableReference.compareAndSet(atomicMarkableReference.getReference(), TEMP_NUM, atomicMarkableReference.isMarked(), Boolean.TRUE);
            System.out.println(Thread.currentThread().getName() + " ： 修改后的值为：" + atomicMarkableReference.getReference() + " , 标记为： " + atomicMarkableReference.isMarked());
            // CAS修改  20 ---> 10
            atomicMarkableReference.compareAndSet(atomicMarkableReference.getReference(), INIT_NUM, atomicMarkableReference.isMarked(), Boolean.TRUE);
            System.out.println(Thread.currentThread().getName() + " ： 修改后的值为：" + atomicMarkableReference.getReference() + " , 标记为： " + atomicMarkableReference.isMarked());

        }, "线程B").start();
    }
}
