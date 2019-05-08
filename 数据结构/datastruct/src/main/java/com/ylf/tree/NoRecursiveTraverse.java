package com.ylf.tree;

import org.junit.Test;

/**
 * 二叉树的非递归遍历
 */
public class NoRecursiveTraverse {   //非递归先序遍历二叉树
     public static void PreOrder(TreeNode root){
          TreeNode p=root;
          Stack<TreeNode> stack=new Stack<>();
          while(p!=null||!stack.isEmpty()){
              while(p!=null){
                  System.out.println(p.data);
                  stack.push(p);
                  p=p.left;
              }
              if(!stack.isEmpty()){
                  p=stack.pop();
                  p=p.right;
              }

          }
     }

     public static void InOrder(TreeNode root){  //非递归中序遍历二叉树
         TreeNode p=root;
         Stack<TreeNode> stack=new Stack<>();
         while(p!=null||!stack.isEmpty()){
             while(p!=null){
                 stack.push(p);
                 p=p.left;
             }
             if(!stack.isEmpty()){
                 p=stack.pop();
                 System.out.println(p.data);
                 p=p.right;
             }
         }
     }

     public static void PostOrder(TreeNode root){  //非递归后续遍历二叉树
         TreeNode p=root;
         TreeNode q=null;
         Stack<TreeNode> stack=new Stack<>();
         while(p!=null||!stack.isEmpty()){
             while (p!=null){
                 stack.push(p);
                 p=p.left;
             }
             if(!stack.isEmpty()){
                 p=stack.top();
                 if(p.right==null||p.right==q){
                     p=stack.pop();
                     System.out.println(p.data);
                     q=p;
                     p=null; //防止p再次入栈
                 }
                 else{
                     p=p.right;
                 }
             }
         }
     }

    public static void main(String[] args){
            TreeNode root=null;
            root=BiTree.createTree(root);
            PostOrder(root);
    }
}
