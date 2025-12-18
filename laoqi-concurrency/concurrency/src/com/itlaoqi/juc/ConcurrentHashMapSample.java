package com.itlaoqi.juc;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConcurrentHashMapSample {
    public static int users = 100;//同时模拟的并发访问用户数量
    public static int downTotal = 50000; //用户下载的真实总数
    public static ConcurrentHashMap count = new ConcurrentHashMap() ;//计数器

    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(users);
        for(int i = 0 ; i < downTotal ; i++){
            final Integer index = i;
            executorService.execute(()->{
                //通过多线程模拟N个用户并发访问并下载
                try {
                    semaphore.acquire();
                    count.put(index, index);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();//关闭调度服务
        System.out.println("下载总数：" + count.size());
    }

}
