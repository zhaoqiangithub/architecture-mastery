package com.itlaoqi.juc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListSample {
    public static void main(String[] args) {
        //写复制列表
        List<Integer> list = new CopyOnWriteArrayList<>();
        for(int i = 0 ; i < 1000 ; i++){
            list.add(i);
        }
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            list.remove(i);
        }
        System.out.println(list);
    }
}
