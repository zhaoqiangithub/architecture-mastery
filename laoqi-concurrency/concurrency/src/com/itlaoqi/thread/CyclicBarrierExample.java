package com.itlaoqi.thread;

import java.util.TreeMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    // 所有线程都达到这个点，才能继续往下执行
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": 准备执行");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + ": 执行中");
                }
            });
        }
        executorService.shutdown();

    }
}
