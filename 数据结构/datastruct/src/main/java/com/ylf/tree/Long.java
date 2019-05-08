package com.ylf.tree;

import java.util.concurrent.atomic.AtomicLong;

public class Long {
    public static void main(String[] args){
        AtomicLong a=new AtomicLong();
        a.addAndGet(1);
        System.out.println(a.get());
    }
}
