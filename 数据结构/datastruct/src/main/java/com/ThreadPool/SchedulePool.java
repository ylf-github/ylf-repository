package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定长周期执行任务
 */
public class SchedulePool {
    public static void main(String[] args){
        ExecutorService pool= Executors.newScheduledThreadPool(3);
        ((ScheduledExecutorService) pool).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"=============");
            }
        },0,3000, TimeUnit.MILLISECONDS);

        ((ScheduledExecutorService) pool).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+System.nanoTime());
            }
        },0,2000,TimeUnit.MILLISECONDS);

    }
}
