package com.ylf.tree;

/**
 * 队列
 * @param <T>
 */
public class Queue<T> {
    public T[] queue=(T[])new Object[100];
    int front=-1;
    int rear=-1;

    public boolean isFull(){  //判队满
        return rear==99;
    }

    public boolean isEmpty(){  //判队空
        return front==rear;
    }

    public void push(T t){     //入队列
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        else{
            queue[++rear]=t;
        }

    }

    public T pop(){           //出队列
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        else{
            return queue[++front];
        }
    }


}
