package com.itlaoqi.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        final Object lock = new Object();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
//                        synchronized (lock) {
                            System.out.println(Thread.currentThread().getName() + ": 线程执行" + (++count));
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        countDownLatch.countDown();
                    }
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("count:" + count);

        executorService.shutdown();

    }



}
