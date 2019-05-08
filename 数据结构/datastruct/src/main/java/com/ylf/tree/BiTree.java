package com.ylf.tree;

<<<<<<< HEAD
import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;

=======
import java.util.Scanner;
>>>>>>> by_19/5/8
/**
 * 二叉树
 */
public class BiTree{

    private static TreeNode root;


    public BiTree(){
        root=null;
    }

    public static TreeNode createTree(TreeNode node){  //中序建立二叉树
        Scanner in=new Scanner(System.in);
        System.out.println("请输入节点的值:");
        int value=in.nextInt();
        if(value!=0){
            node=new TreeNode();
            node.data=value;
            node.left=createTree(node.left);           //建立左子树
            node.right=createTree(node.right);         //建立右子树
        }
        else {
            node=null;
        }
        return node;
    }

    public static void preOrder(TreeNode root){ //递归先序
        if(root!=null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root){ //递归中序
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root){ //递归中序
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public static TreeNode createSort(TreeNode node,int value) { //排序二叉树

        if (node == null) {
            node=new TreeNode();
            node.data = value;
        } else {
            if (value> node.data) {
                if (node.right == null) {
                    node.right=new TreeNode();
                    node.right.data = value;
                } else {
                     createSort(node.right,value);
                }
            }
            else{
                if (node.left == null) {
                    node.left=new TreeNode();
                    node.left.data = value;
                } else {
                    createSort(node.left,value);
                }
            }

        }

        return node;
    }

    public static void add(int value){    //添加一个节点
        root=createSort(root,value);

    }


    public static void main(String[] args){
//        add(1);
//        add(5);
//        add(3);
//        add(4);
//        add(6);
//        add(11);
//        add(103);
        root=createTree(root);
        inOrder(root);

    }
}
