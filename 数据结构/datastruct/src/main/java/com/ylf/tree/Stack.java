package com.ylf.tree;


public class Stack<T> {
    public  T[] array=(T[])new Object[100];
    int top=-1;

    public  T pop(){  //出栈
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        else{
            return array[top--];
        }

    }

    public T top(){   //获取栈顶数据
        return array[top];
    }

    public void push(T t){ //入栈
        if(isFull()){
            throw new RuntimeException("栈已满");
        }
        else{
            array[++top]=t;
        }
    }

    public boolean isEmpty(){  //判栈空
        return top==-1;
    }

    public boolean isFull(){  //判栈满
        return top==99;
    }
}
