package com.ThreadPool;


import java.util.concurrent.*;

public class ThreadPoolExecuter {
    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor pool=new ThreadPoolExecutor(2,3,6, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        Thread t1=new MyThread();
        Thread t2=new MyThread();
        Thread t3=new MyThread();
        Thread t4=new MyThread();
        Thread t5=new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.shutdown();
    }
}
