package com.itlaoqi.runtime.stack;

/**
 * 操作数栈案例
 * 字节码指令在执行过程中的中间计算过程存储在操作数栈
 * @author itlaoqi.com
 */
public class OperandStackSample {
    public int compute1(){
        short i = 10;
        int j = 18;
        int k = i + j;
        return k;
    }

    //long/double占2个slot,栈占2个深度
    public double compute2(){
        double i = 10;
        long j = 18;
        double k = i + j;
        return k;
    }
}
