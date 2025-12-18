package com.itlaoqi.thread;

import java.util.Random;

public class Match2 {
    public static void main(String[] args) {
        Runner2 liuxiang = new Runner2();
        Thread thread1 = new Thread(liuxiang);
        thread1.setName("刘翔");

        Thread laoqi = new Thread(new Runner2());
        laoqi.setName("老齐");

        Thread op = new Thread(new Runner2());
        op.setName("路飞");

        thread1.start();
        laoqi.start();
        op.start();
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        Integer speed = new Random().nextInt(100);
        for(int i = 1 ; i <= 100 ; i++){
            try {
                Thread.sleep(1000); //当前线程休眠1秒
            }catch (Exception e){
                e.printStackTrace();
            }
            //Thread.currentThread()用于获取当前执行的线程对象
            //在Runnable中是无法使用this获取到当前线程对象的
            System.out.println(Thread.currentThread().getName() + "已前进" + (i * speed) + "米（" + speed + "米/秒)");
        }
    }
}
