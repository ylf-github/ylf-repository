package com.algorithm;

import com.ylf.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 打印左、右视图、打印换行按层遍历
 */
public class LeftTreeView {


    public static TreeNode creTree(TreeNode node){  //创建二叉树
        Scanner in=new Scanner(System.in);
        System.out.println("请输入节点值:");
        int value=in.nextInt();
        if(value!=0){
            node=new TreeNode();
            node.data=value;
            node.left=creTree(node.left);
            node.right=creTree(node.right);
        }
        else{
           node=null;
        }
        return node;
    }

    public static void printLeftView(TreeNode root){    //打印二叉树左视图
        if(root!=null){
            TreeNode last=root;   //存放当前层的最后一个节点
            TreeNode nlast=null;  //存放下一层的最后一个节点
            LinkedList<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            int flag=1;
            while(!queue.isEmpty()){
                TreeNode t=queue.peek();
                if(t==last){
                    System.out.println(queue.poll().data);
                    flag=0;
                }
                else{
                    queue.poll();
                }
                if(t.left!=null){
                    queue.offer(t.left);
                    nlast=t.left;
                }
                if(t.right!=null){
                    queue.offer(t.right);
                    nlast=t.right;
                }
                if(t==last){  //判断是否达到一层的最后,换层
                    flag=1;
                    last=nlast;
                }
            }
        }
    }


    public static void printRightView(TreeNode root){  //打印右视图
        if(root!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            TreeNode last=root;     //存放当前层的最后一个节点
            TreeNode nlast=null;    //存放下一层的最后一个节点
            int flag=1;
            while(!queue.isEmpty()){
                TreeNode t=queue.peek();
                if (t==last){
                    System.out.println(queue.poll().data);
                }
                else{
                    queue.poll();
                }
                if(t.left!=null){
                    queue.offer(t.left);
                    nlast=t.left;
                }
                if(t.right!=null){
                    queue.offer(t.right);
                    nlast=t.right;
                }
                if(t==last){   //判断是否到达最后一个节点更新last值
                    last=nlast;
                }
            }

        }
    }

    public static void printBr(TreeNode root){ //每遍历一层打印一个换行符
        if(root!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            TreeNode last=root;     //记录当前层最后一个节点
            TreeNode nlast=null;    //记录下一层最后一个节点
            while(!queue.isEmpty()){
                TreeNode t=queue.peek();
                if(t==last){
                    System.out.println(queue.poll().data);
                }
                else{
                    System.out.print(queue.poll().data+" ");
                }
                if(t.left!=null){
                    queue.offer(t.left);
                    nlast=t.left;
                }
                if(t.right!=null){
                    queue.offer(t.right);
                    nlast=t.right;
                }
                if(t==last){    //换层后更新last
                    last=nlast;
                }
            }
        }
    }



    public static void main(String[] args){
        TreeNode root=null;
        root=creTree(root);
        //printLeftView(root);
        //printRightView(root);
        printBr(root);
    }
}
