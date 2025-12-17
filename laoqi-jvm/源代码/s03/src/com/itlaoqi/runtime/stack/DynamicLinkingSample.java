package com.itlaoqi.runtime.stack;

/**
 * 动态链接与返回地址案例
 */
public class DynamicLinkingSample {

    public void s1() {
        System.out.println("S1 - Start");
        this.s2();
        System.out.println("S1 - End ");
    }
    public void s2() {
        System.out.println("S2 - Start");
        this.s3();
        System.out.println("S2 - End ");
    }
    public void s3() {
        System.out.println("S3 - Start");
        this.s4();
        System.out.println("S3 - End ");
    }
    public void s4() {
        System.out.println("S4 - Start");
        System.out.println("S4 - End ");
    }
    public static void main(String[] args) {
        new DynamicLinkingSample().s1();
    }
}
