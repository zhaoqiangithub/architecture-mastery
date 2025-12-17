package com.itlaoqi.thread;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafe {

    private static int a = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
//                synchronized (lock) {
                    a = add(a);
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(a);


    }

    private static int add(int a) {
        a += 1;
        return a;
    }

}
