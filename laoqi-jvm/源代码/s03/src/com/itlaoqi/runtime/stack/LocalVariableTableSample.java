package com.itlaoqi.runtime.stack;

import java.util.Date;

/**
 * 局部变量表案例
 * 案例总结:
 * 1. LineNumberTable说明了字节码指令和源码行号的对应关系
 * 2. LocalVariableTable在编译期间就保存在字节码中,长度固定,方法调用时随栈帧创建并载入
 * 3. 存储局部变量的单位为Slot(变量槽) ,对应LocalVariableTable的Index列
 * 4. LocalVariableTable在构造方法与实例方法中,0号槽位(Slot)默认为this,指向当前类实例
 * 5. static方法没有this关键字
 * 6. LocalVariableTable
 *    StartPC代表局部变量作用域起始字节码指令行号
 *    Length代表作用的字节码指令范围
 * 7. 槽(Slot)按类型区分,32位以内类型(int/float/char/.../引用类型)占用1个Slot
 *    64位类型(long/double)占用2个Slot
 * 8. 当槽位有空余时,后产生的局部变量会重用之前的槽位,此特性称为"槽复用"
 **/
public class LocalVariableTableSample {

    public LocalVariableTableSample(){
        this.slotSample1();
    }

    public static String staticMethod(String name,int offset){
        String ret = "hello " + name;
        int count = 100 + offset;
        return ret;
    }

    public String instanceMethod(String name,int offset){
        String ret = "hello " + name;
        int count = 100 + offset;
        return ret;
    }

    public void slotSample1() {
        int a = 1;
        float b = 0f;
        boolean c = true;
        long d = 100;
        double e = 100;
        String f = "";
    }

    public void slotSample2() {
        int a = 1;
        if(1==1){
            int b = 0;
            b = a + 1;
        }
        int c = 100;
    }

    public static void main(String[] args) {
        LocalVariableTableSample.staticMethod("Lily" , 100);
        LocalVariableTableSample instance = new LocalVariableTableSample();
        instance.instanceMethod("Andy" , 200);
    }
}
