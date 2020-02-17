package com.example.concurrent.concurrenthashmap.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2020-01-15 07:37
 * @Description: ConcurrentHashMap使用
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        // 不要使用Executors创建线程池，此处只为方便起见才使用，
        // 开发中应当使用ThreadPoolExecutor创建线程池。
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        try {
            for (int i = 1; i <= 10; i++) {
                int value = i;
                executorService.submit(() -> {
                    concurrentHashMap.putIfAbsent(Thread.currentThread().getName(), String.valueOf(value));
                });
            }
            System.out.printf("concurrentHashMap大小=%s%n", concurrentHashMap.size());
            System.out.println("concurrentHashMap中的元素：");
            for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            // 删除key:pool-1-thread-1
            executorService.submit(() -> {
                concurrentHashMap.remove("pool-1-thread-1");
            });
            // 查询key:pool-1-thread-1
            executorService.submit(() -> {
                String value = concurrentHashMap.getOrDefault("pool-1-thread-1", "pool-1-thread-1被删除");
                System.out.printf("pool-1-thread-1对应的value=%s%n", value);
            });
        } finally {
            executorService.shutdown();
        }
    }
}
