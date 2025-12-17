package com.itlaoqi.classloader;

/**
 * 类加载过程值初始化Initialization
 * 知识点1: 初始化阶段运行<clint>(),对类(静态)变量赋值与执行static代码块
 *  prepare准备阶段: start = 0;offset=0
 *  initialization初始化阶段: start = 10;offset=30,并执行static{}
 *
 * 知识点2: 子类初始化过程会优先执行父类<clint>()
 * 知识点3: 没有类变量及static{}代码块就不会产生<clint>()
 * 知识点4: 启动时增加VM选项 -XX:+TraceClassLoading查看类加载过程
 *
 * 知识点5: <clint>()方法默认会增加同步锁,在多线程同时加载类的时候
 *         只有第一个线程会执行<clint>(),其他线程处于阻塞等待状态
 *         当第一个线程执行<clint>()后,代表该类已加载完毕,后续线程不会再执行<clint>()
 */
public class ClassInitSample extends Base{
    private static int start = 10;
    private static int offset = 30;
    static{
        offset = 60;
        start = start + offset;
        System.out.println("子类<clint>()已执行");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        new ClassInitSample();
    }*/

    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i++) {

            Thread t = new Thread(()->{
                new ClassInitSample();
            } , "线程" + i);
            System.out.println(t.getName() + "执行完毕");
        }
    }



}
