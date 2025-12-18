package com.itlaoqi.juc;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSample4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool =  Executors.newScheduledThreadPool(5);//可调度线程池
        /*//延迟三秒执行一次Run方法
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟3秒执行");
            }
        } , 3 , TimeUnit.SECONDS);*/
        //Timer , 项目实际开发中scheduledThreadPool与Timer都不会用到，应为有成熟的调度框架Quartz，或者Spring自带调度，
        //程序的调度框架支持一种表达式叫做Cron表达式，有兴趣的童鞋可以了解一下。
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + "延迟1秒执行，每三秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
