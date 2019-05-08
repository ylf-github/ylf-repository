package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglePool {
    public static void main(String[] args){
        ExecutorService pool= Executors.newSingleThreadExecutor();
        Thread t1=new MyThread();
        Thread t2=new MyThread();
        Thread t3=new MyThread();
        Thread t4=new MyThread();
        pool.execute(t1);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });
        pool.shutdown();
    }
}
