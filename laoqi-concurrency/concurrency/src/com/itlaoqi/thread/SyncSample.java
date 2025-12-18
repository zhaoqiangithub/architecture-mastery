package com.itlaoqi.thread;

import java.util.Random;

public class SyncSample {
    public static void main(String[] args) {
        Couplet c = new Couplet();
        for(int i = 0 ; i < 10000 ; i++){
            new Thread(){
                public void run(){
                    int r = new Random().nextInt(2);
                    if(r % 2 == 0){
                        Couplet.first();
                    }else{
                        Couplet.second();
                    }
                }
            }.start();
        }
    }
}
class Couplet{
    Object lock = new Object(); //锁对象
    public synchronized static void first(){
//        synchronized (lock) { //同步代码块，在同一时间只允许有一个线程执行访问这个方法
            System.out.printf("琴");
            System.out.printf("瑟");
            System.out.printf("琵");
            System.out.printf("琶");
            System.out.println();
//        }
    }
    public static void second(){
        synchronized (Couplet.class) { //因为两个同步代码指向了同一把锁lock，所以在同一个时间内只允许有一个代码块执行，其他等待
            System.out.printf("魑");
            System.out.printf("魅");
            System.out.printf("魍");
            System.out.printf("魉");
            System.out.println();
        }

    }
}
