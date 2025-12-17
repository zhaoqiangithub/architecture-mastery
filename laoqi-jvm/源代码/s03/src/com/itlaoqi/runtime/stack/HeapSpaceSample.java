package com.itlaoqi.runtime.stack;

/**
 * 1. 设置堆空间大小的参数
 * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
 * -Xmx 用来设置堆空间（年轻代+老年代）的最大内存大小
 *
 * 2. 默认堆空间的大小
 *    初始内存大小：物理电脑内存大小 / 64
 *    最大内存大小：物理电脑内存大小 / 4
 *
 * 3. 年轻代与老年代的占用比例:
 *    a. 年轻代固定占用1/3
 *    b. 老年代固定占用2/3
 *
 * 4. 手动设置：-Xms1g(m) -Xmx1g(m)
 *    a.开发中建议将初始堆内存和最大的堆内存设置成相同的值。
 *    b.Java整个堆大小设置建议，Xmx 和 Xms设置为老年代FullGC后存活对象的3-4倍
 *
 * 5. 查看设置的参数： -XX:+PrintGCDetails
 * @author IT老齐
 */
public class HeapSpaceSample {
    public static void main(String[] args) {
        //返回Java虚拟机中的堆内存总量
        long usedMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回Java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("堆当前占用 : " + usedMemory + "M");
        System.out.println("堆最大内存 : " + maxMemory + "M");
        /*try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
