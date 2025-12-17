package com.itlaoqi.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownExample {

    private static int count = 0;
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Object lock = new Object();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (lock) {
                            System.out.println(Thread.currentThread().getName() + ": 线程执行" + (++count));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        // 所有的子线程执行完，主线程再继续执行。取代睡眠，因为你无法准确直到睡眠多久
        // 必须数量一致，否则主线程一直阻塞
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("count:" + count);
        executorService.shutdown();

    }



}
