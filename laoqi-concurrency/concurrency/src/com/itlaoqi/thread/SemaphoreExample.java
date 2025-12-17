package com.itlaoqi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Runnable () {
                @Override
                public void run() {
//                    try {
//                        semaphore.acquire();
//
//                        Thread.sleep(1000);
//                        System.out.println(Thread.currentThread().getName() + "执行中");
//                        semaphore.release();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }

                    try {
                        if (semaphore.tryAcquire(6, TimeUnit.SECONDS)) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "执行中");
                                Thread.sleep(2000);
                                System.out.println(Thread.currentThread().getName() + "执行完毕");
                                Thread.sleep(500);
                                semaphore.release();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + "对不起，服务器已满");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();

    }
}
