package com.itlaoqi.classloader.custom;

public class Application {


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader c1 = new MyClassLoader1() ;
        //利用自定义加载器1加载对象\
        //调用ClassLoader.loadClass()加载字节码会自动调用findClass方法
        Class<?> clz1 = c1.loadClass("ClassSample");
        System.out.println(clz1.getClassLoader() + "|hashcode:" + clz1.hashCode());

        ClassLoader c2 = new MyClassLoader2() ;
        //利用自定义加载器1加载对象
        Class<?> clz2 = c2.loadClass("ClassSample");
        System.out.println(clz2.getClassLoader() + "|hashcode:" + clz2.hashCode());

        System.out.println("结论:同一个Class被不同的类加载器加载后在JVM中产生的类对象是不同的");
        System.out.println("推导:在同一个类加载器作用范围内Class实例加载时才会保持唯一性");

    }
}
