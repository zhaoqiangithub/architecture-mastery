package com.itlaoqi.classloader;

import sun.security.ec.SunEC;

/**
 * 类加载器案例
 */
public class ClassLoaderSample {
    public static void main(String[] args) {
        //对于用户自定义类来说：默认使用应用程序类加载器进行加载
        ClassLoader appClassLoader = ClassLoaderSample.class.getClassLoader();
        System.out.println(appClassLoader);//sun.misc.Launcher$AppClassLoader

        //扩展类加载器
        ClassLoader extClassLoader = SunEC.class.getClassLoader();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader

        //启动类加载器,因为启动类加载器使用C语言编写,没有被JVM管理,所以启动类加载器返回null
        ClassLoader bootstrapClassLoader = Object.class.getClassLoader();
        System.out.println(bootstrapClassLoader);//null

    }
}
