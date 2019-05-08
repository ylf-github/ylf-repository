package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 缓存线程池
 */
public class CachePool {
       public static void main(String[] args){
           ExecutorService pool= Executors.newCachedThreadPool();
           Thread t1=new MyThread();
           Thread t2=new MyThread();
           Thread t3=new MyThread();
           Thread t4=new MyThread();
           pool.execute(t1);
           pool.execute(t2);
           pool.execute(t3);
           pool.execute(t4);
           pool.shutdown();

       }
}
