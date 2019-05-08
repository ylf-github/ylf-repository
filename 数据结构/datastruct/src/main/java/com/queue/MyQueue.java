package com.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args){
        Queue queue=new PriorityQueue<Integer>(3);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(4);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
