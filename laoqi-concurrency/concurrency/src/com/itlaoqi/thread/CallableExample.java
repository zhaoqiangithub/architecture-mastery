package com.itlaoqi.thread;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            Computer computer = new Computer();
            computer.setNum(i);
            Future<Boolean> result = executorService.submit(computer);
            try {
                Boolean b = result.get();
                System.out.println("数字" + i + "是否为质数："+ b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Computer implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":开始计算:" + num);
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
