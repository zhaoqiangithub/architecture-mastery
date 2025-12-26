package com.itlaoqi.methodaspect;

import java.lang.instrument.Instrumentation;

public class MyJavaAgent {
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("MyJavaAgent is running!");

        // Add a transformer to modify the bytecode of loaded classes
        MyTransformer transformer = new MyTransformer();
        instrumentation.addTransformer(transformer);
    }
}
