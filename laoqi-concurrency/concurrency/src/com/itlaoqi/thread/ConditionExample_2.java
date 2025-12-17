package com.itlaoqi.thread;

import java.util.concurrent.*;

public class ConditionExample_2 {


    public static void main(String[] args) {
        Semaphore cyclicBarrier = new Semaphore(0);
        Semaphore cyclicBarrier1 = new Semaphore(0);
        Semaphore cyclicBarrier2 = new Semaphore(0);


        new Thread(() -> {
            System.out.println("锄禾日当午");
            cyclicBarrier.release();
        }).start();

        new Thread(() -> {
            try {
//                if (cyclicBarrier2.tryAcquire(7, TimeUnit.SECONDS)) {
//                    System.out.println("粒粒皆辛苦");
//                }
                cyclicBarrier2.acquire();
                System.out.println("粒粒皆辛苦");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
//                if (cyclicBarrier1.tryAcquire(6, TimeUnit.SECONDS)) {
//                    System.out.println("谁知盘中餐");
//                }
                cyclicBarrier1.acquire();
                System.out.println("谁知盘中餐");
                cyclicBarrier2.release();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();


        new Thread(() -> {
            try {
                Thread.sleep(5000);
//                if (cyclicBarrier.tryAcquire(5, TimeUnit.SECONDS)) {
//                    System.out.println("汗滴禾下土");
//                }
                cyclicBarrier.acquire();
                System.out.println("汗滴禾下土");
                cyclicBarrier1.release();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();


    }

}
