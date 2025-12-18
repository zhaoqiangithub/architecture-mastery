package com.itlaoqi.juc;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        ForkJoinTaskExample item1 = new ForkJoinTaskExample(1,10000);
        ForkJoinTaskExample item2 = new ForkJoinTaskExample(10001 , 20000);
        ForkJoinTaskExample item3 = new ForkJoinTaskExample(20001 , 30000);
        ForkJoinTaskExample item4 = new ForkJoinTaskExample(30001 , 40000);

        // 执行子任务
        item1.fork();
        item2.fork();
        item3.fork();
        item4.fork();

        // 等待任务执行结束合并其结果
        int r1 = item1.join();
        int r2 = item2.join();
        int r3 = item3.join();
        int r4 = item4.join();

        // 合并子任务
        sum = r1 + r2 + r3 + r4;

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 40000);

        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(task);

        try {
            System.out.println( result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
