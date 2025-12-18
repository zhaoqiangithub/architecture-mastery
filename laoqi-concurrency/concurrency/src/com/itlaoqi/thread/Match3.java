package com.itlaoqi.thread;

import java.util.Random;
import java.util.concurrent.*;

public class Match3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池。里面天生有3个“空”线程。Executors是调度器，对线程池进行管理
        ExecutorService executorService =  Executors.newFixedThreadPool(3);
        Runner3 liuxiang = new Runner3();//实例化Callable对象
        liuxiang.setName("刘翔");
        Runner3 laoqi = new Runner3();
        laoqi.setName("老齐");
        Runner3 op = new Runner3();
        op.setName("路飞");

        //将这个对象扔到线程池中，线程池自动分配一个线程来运行liuxiang这个对象的call方法
        //Future用于接受线程内部call方法的返回值
        Future<Integer> result1 =  executorService.submit(liuxiang);
        Future<Integer> result2 =  executorService.submit(laoqi);
        Future<Integer> result3 =  executorService.submit(op);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();//关闭线程池释放所有资源
        System.out.println("刘翔累计跑了" + result1.get() + "米" );
        System.out.println("老齐累计跑了" + result2.get() + "米" );
        System.out.println("路飞累计跑了" + result3.get() + "米" );
    }
}
class Runner3 implements Callable<Integer>{
    private String name ;
    public void setName(String name){
        this.name = name;
    }
    //实现Callable接口可以允许我们的线程返回值或抛出异常
    @Override
    public Integer call() throws Exception {
        Integer speed = new Random().nextInt(100);
        Integer distince = 0; //总共奔跑的距离
        for(int i = 1 ; i <= 100 ; i++){
            Thread.sleep(10);
            distince = i * speed;
            System.out.println(this.name + "已前进" + distince + "米(" + speed + "米/秒)");
        }
        return distince;
    }
}
