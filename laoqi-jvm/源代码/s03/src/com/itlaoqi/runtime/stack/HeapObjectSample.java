package com.itlaoqi.runtime.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆对象状态变化
 * @Author IT老齐
 */
public class HeapObjectSample {
    /**
     * VM参数：-Xms60M -Xmx60M -Xmn10M  -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     * -Xms60M -Xmx60M 堆内存总大小60mb
     * -Xmn10M 强制设置新生代10mb,剩余50mb分给老年代
     * -XX:SurvivorRatio=8 设置Eden与Survivor比例为8:1:1 ,即eden为8mb / S0与S1各1mb
     * -XX:+PrintGCDetails 打印详细GC日志
     *
     * 日志分析:
     * [GC (Allocation Failure) [PSYoungGen: 8178K->1002K(9216K)] 8178K->4928K(60416K), 0.0018061 secs]
     *  GC (Allocation Failure) : Allocation Failure说明触发GC的原因是Eden空间不足
     *  8178K->1002K(9216K):GC前年轻代空间->GC后年轻代空间(年轻代最大占用空间)
     *  PS:为什么年轻代最大空间是9216K,不是10240(10mb)
     *  答:年轻代组成为 Eden(8mb)+ 2*(Survivor(1mb)) ,但两个S区只有一个有数据,所以在内存分配时只需分配1个即:8mb+1mb=9216k
     *  8178K->4928K(60416K):GC前堆占用空间->GC后堆占用(堆最大占用空间)
     *  0.0018061 secs: 本次GC使用时间
     *
     *  [Full GC (Ergonomics)       [PSYoungGen: 8192K->8177K(9216K)] [ParOldGen: 51184K->51184K(51200K)] 59376K->59361K(60416K), [Metaspace: 9320K->9320K(1058816K)]
     *  Ergonomics(GC收集器策略执行)  年轻代                              老年代                                                       元空间(方法区)
     *  [Full GC (Allocation Failure) ...
     *  Allocation Failure: 堆空间分配失败,会抛出OOM
     */
    public static void case1() {
        List list = new ArrayList();
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(new byte[1024 * 50]);
        }
    }

    public static void main(String[] args) {
        case1();
    }
}
