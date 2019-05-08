package com.ylf.review;
public class Node<T> {            //链表节点
    public T data;
    public Node<T> next;
    public Node(T data){
        this.data=data;
        this.next=null;
    }
}
