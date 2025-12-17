package com.itlaoqi.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            lock.lock();
            try {
                System.out.println("锄禾日当午");
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {
                condition2.await();
                System.out.println("粒粒皆辛苦");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            lock.lock();
            try {
                Thread.sleep(1000);
                condition1.await();
                System.out.println("谁知盘中餐");
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();



        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {
                condition.await();
                System.out.println("汗滴禾下土");
                condition1.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }
        }).start();



    }

}
