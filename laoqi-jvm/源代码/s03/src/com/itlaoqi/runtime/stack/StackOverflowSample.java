package com.itlaoqi.runtime.stack;

/**
 * 演示栈溢出StackOverflowError
 */
public class StackOverflowSample {
    private static long count = 0;
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        count++;
        int a,b,c,d,e,f,g,h,i,j,k=0;
        System.out.println("正在第" + count + "次调用方法");
        test();
    }
}
