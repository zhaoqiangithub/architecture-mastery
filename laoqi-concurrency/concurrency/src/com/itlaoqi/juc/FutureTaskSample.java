package com.itlaoqi.juc;

import java.util.concurrent.*;

public class FutureTaskSample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 2 ; i <= 10000 ; i++) {
            final int num = i;
            FutureTask<Boolean> task = new FutureTask<Boolean>(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    boolean isprime = true;
                    for (int i = 2; i < num; i++) {
                        if (num % i == 0) {
                            isprime = false;
                            break;
                        }
                    }
                    
                    return isprime;
                }
            });
            executorService.execute(task);
            try {
                if(task.get()){
                    System.out.println(num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


    }
}
