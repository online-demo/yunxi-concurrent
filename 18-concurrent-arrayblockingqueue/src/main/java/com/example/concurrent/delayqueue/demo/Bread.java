package com.example.concurrent.delayqueue.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-10-02 10:19
 * @Description: 面包类
 */
public class Bread {
    private Integer price;
    public Bread (Integer name) {
        this.price = name;
    }

    @Override
    public String toString() {
        return "面包价格为：" + price;
    }
}
