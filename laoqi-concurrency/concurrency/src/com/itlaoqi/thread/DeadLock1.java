package com.itlaoqi.thread;

public class DeadLock1 {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {
        // 线程 1 获取到锁 1（独占），尝试获取锁 2
        // 线程 2 获取到锁 2（独占），尝试获取锁 1
        new Thread(() -> {
            while(true) {
                synchronized (lock1) {
                    System.out.println("lock1执行");
                    synchronized (lock2) {
                        System.out.println("lock2执行");
                    }
                }
            }
        }).start();


//        new Thread(() -> {
//            while(true) {
//                synchronized (lock2) {
//                    System.out.println("lock1执行");
//                    synchronized (lock1) {
//                        System.out.println("lock2执行");
//                    }
//                }
//            }
//        }).start();

    }



}
