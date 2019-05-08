package com.ylf.review;
import org.junit.Test;

/**
 * 单链表尾插法
 * @param <T>
 */
public class LinkList<T> {
    private Node<T> head;   //表头
    private Node<T> tail;   //指向尾部的指针
    private int size;       //记录链表长度
    public LinkList(){
        this.head=null;
        this.tail=null;
    }
    public void addNode(T data){       //添加一个节点
        if(head==null){
            head=new Node<T>(data);
            tail=head;
            size++;
            return;
        }
        tail.next=new Node<T>(data);
        tail=tail.next;
        size++;
    }
    public void print(){            //打印链表数据
        Node<T> tempNode=head;
        while(tempNode!=null){
            System.out.print(tempNode.data+" ");
            tempNode=tempNode.next;
        }
    }
    //@Test
    public void testAddNode(){
        LinkList<Integer> list=new LinkList<>();
        list.addNode(1);
        list.addNode(4);
        list.addNode(2);
        list.print();

    }
    public boolean delNode(int index){     //删除指定下标的节点
        if(index<0||index>=size){
            throw new RuntimeException("下标越界");
        }
        if(index==0){
            head=head.next;
            size--;
            return true;
        }
        Node<T> preNode=head;
        int count=0;
        while(count<index-1){
            preNode=preNode.next;
            count++;
        }
        preNode.next=preNode.next.next;
        size--;
        return true;
    }
    //@Test
    public void testDeleteNode(){
        LinkList<Integer> list=new LinkList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.print();
        System.out.println();
        list.delNode(2);
        list.print();
    }
    public int insertNode(int index,T data){       //指定下标插入节点
        if(index<0||index>size){
            throw new RuntimeException("下标越界");
        }
        if(index==0) {
            Node<T> node = new Node<>(data);
            node.next = head;
            head = node;
            size++;
            return 0;
        }
        if(index==size){
            Node<T> node = new Node<>(data);
            tail.next=node;
            tail = node;
            size++;
            return index;
        }
        Node<T> node=new Node<>(data);
        Node<T> preNode=head;
        int count=1;
        while (count<index){
            preNode=preNode.next;
            count++;
        }
        node.next=preNode.next;
        preNode.next=node;
        size++;
        return index;
    }
    @Test
    public void testInsertNode(){
        LinkList<Integer> list=new LinkList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(4);
        list.insertNode(3,3);
        list.addNode(6);
        list.print();
    }

}
