package com.ThreadPool.callable;

import java.util.concurrent.Callable;

public class Task implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"Thread is Running");
        return 110;
    }
}
