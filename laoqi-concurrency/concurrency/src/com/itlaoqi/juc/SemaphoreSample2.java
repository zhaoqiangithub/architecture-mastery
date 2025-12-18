package com.itlaoqi.juc;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreSample2 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(5);//定义5个信号量，也就是说服务器只允许5个人在里面玩
        for(int i = 1 ; i <= 20 ; i++) {
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //尝试获取一次信号量，5秒钟内获取到返回true，否则返回false
                        if(semaphore.tryAcquire(6, TimeUnit.SECONDS)) {
                            play();
                            semaphore.release();//执行完成后释放这个信号量，“从跑道出去”
                        }else{
                            System.out.println(Thread.currentThread().getName() + ":对不起，服务器已满，请稍后再试");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        threadPool.shutdown();
    }

    public static void play(){

        try {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ":获得紫禁之巅服务器进入资格");
            Thread.sleep(2000);
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ":退出服务器");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
