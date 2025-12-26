package com.itlaoqi.hello;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hello", "world");
        System.out.println(map.toString());
    }
}
