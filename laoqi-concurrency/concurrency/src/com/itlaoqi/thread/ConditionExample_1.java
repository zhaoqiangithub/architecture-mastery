package com.itlaoqi.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample_1 {


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);


        new Thread(() -> {
            System.out.println("锄禾日当午");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("粒粒皆辛苦");
        }).start();

        new Thread(() -> {
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("谁知盘中餐");
            countDownLatch2.countDown();
        }).start();


        new Thread(() -> {
            try {
                Thread.sleep(1000);
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("汗滴禾下土");
            countDownLatch1.countDown();
        }).start();


    }

}
