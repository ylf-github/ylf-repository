package com.ThreadPool.callable;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallMain {
    public static void main(String[] args){
        FutureTask future=new FutureTask(new Task());
        Thread t1=new Thread(future);
        t1.setName("haha ");
        t1.start();
        try {
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
