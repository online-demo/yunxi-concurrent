package com.example.atomic.high.performance;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2020-04-05 16:28
 * @Description: LongAdder使用姿势
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        // 自增1
        longAdder.increment();
        // 加666
        longAdder.add(666);
        // 打印总和
        System.out.println(longAdder.sum());

        // 创建LongAccumulator，基数为1
        LongAccumulator longAccumulator
                = new LongAccumulator((left, right) -> left + right * 2, 1);
        // 1 + 1 * 2
        longAccumulator.accumulate(1);
        System.out.println(longAccumulator.get());
        // 1 + 1 * 2 + 3 * 2
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.get());
        // 1 + 1 * 2 + 3 * 2 + -4 * 2
        longAccumulator.accumulate(-4);
        System.out.println(longAccumulator.get());
    }
}
