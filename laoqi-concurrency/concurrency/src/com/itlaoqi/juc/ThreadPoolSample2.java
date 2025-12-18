package com.itlaoqi.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSample2 {
    public static void main(String[] args) {
        //调度器对象
        //ExecutorService用于管理线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);//创建一个可创建一个定长线程池
        //定长线程池的特点是固定线程总数，空间线程用于执行任务，如果线程都在使用后续任务则处于等待状态，在线程池中的线程
        //如果任务处于等待的状态，备选的等待算法默认为FIFO（先进先出) LIFO(后进先出)
        //执行任务后再执行后续的任务。
        for(int i = 1 ; i <= 1000 ; i++) {
            final  int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + index);
                }
            });
        }
        try {
            Thread.sleep(1000); //跟线程足够的运行时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //shutdown() 代表关闭线程池（等待所有线程完成）
        //shutdownNow() 代表立即终止线程池的运行，不等待线程,不推荐使用
        threadPool.shutdown();
    }
}
