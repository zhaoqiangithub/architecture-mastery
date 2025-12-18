package com.itlaoqi.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownSample {
    private static int count = 0;
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        CountDownLatch cdl = new CountDownLatch(10000); //CDL总数和操作数保持一致
        for(int i = 1 ; i <= 10000 ; i++) {
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (CountDownSample.class) {
                        try {
                            count = count + index;
                            //计数器减一
                        }catch(Exception e){
                            e.printStackTrace();
                        }finally {
                            cdl.countDown();
                        }
                    }
                }
            });
        }
/*        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            cdl.await(); //堵塞当前线程，知道cdl=0的时候再继续往下走
            //为了避免程序一致挂起，我们可以设置一个timeout时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        threadPool.shutdown();
    }
}
