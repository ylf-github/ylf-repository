package com.ylf.tree;

/**
 * 常用树的操作
 */
public class TreeSearch {
     public static void bFS(TreeNode root){    //广度优先搜索/遍历二叉树
         TreeNode t=root;
         Queue<TreeNode> queue=new Queue();
         if(t!=null){
             queue.push(t);
         }
         while(!queue.isEmpty()){
             t=queue.pop();
             System.out.println(t.data);
             if(t.left!=null){
                 queue.push(t.left);
             }
             if(t.right!=null){
                 queue.push(t.right);
             }
         }
     }

     public static void dFS(TreeNode root){  //深度遍历二叉树
         TreeNode t=root;
         Stack<TreeNode> stack=new Stack<>();
         if(t!=null){
             stack.push(t);
         }
         while(!stack.isEmpty()){
            t=stack.pop();
            System.out.println(t.data);
             if (t.right != null) {
                 stack.push(t.right);
             }
             if (t.left != null) {
                 stack.push(t.left);
             }

         }
     }
     static int depth=0;
     public static void treeDepth(TreeNode root,int h){  //求二叉树高度
         if(root!=null){
             if(h>depth){
                 depth=h;
             }
             treeDepth(root.left,h+1);
             treeDepth(root.right,h+1);
         }
     }

     public static int recursiveDepth(TreeNode root){    //求二叉树高度
         int ld=0,rd=0;
         if(root==null){
             return 0;
         }
         else {
             ld=recursiveDepth(root.left);
             rd=recursiveDepth(root.right);
             return ld>rd?ld+1:rd+1;
         }

     }

     static int count=0;
     public static void getCount(TreeNode root){   //统计节点数量
         if(root!=null){
             count++;
             getCount(root.left);
             getCount(root.right);
         }
     }

     public static int getEndCount(TreeNode root){  //统计叶子节点数量
         int rn,ln;
         if(root==null){
             return 0;
         }
         if(root.left==null&&root.right==null){
             return 1;
         }
         ln=getEndCount(root.left);
         rn=getEndCount(root.right);
         return ln+rn;

     }

     public static TreeNode getParent(TreeNode root,TreeNode current){ //求节点的父子点
         if(root==null){
             return null;
         }
         if(root.left==current||root.right==current){
             return root;
         }
         TreeNode p=getParent(root.left,current);
         if(p!=null){
             return p;
         }
         else {
             return getParent(root.right,current);
         }
     }

     public static int like(TreeNode root1,TreeNode root2){  //求二叉树相似度
         if(root1==null&&root2==null){
             return 1;
         }
         else if(root1!=null&&root2!=null){
             int like1=like(root1.left,root2.left);
             int like2=like(root1.right,root2.right);
             return like1&like2;
         }
         else{
             return 0;
         }
     }

     public static void main(String[] args){
         TreeNode root=null;
         root=BiTree.createTree(root);
         //dFS(root);
         //treeDepth(root,1);
         //int depth=recursiveDepth(root);
         int n=getEndCount(root);
         System.out.println(n);
     }
}
