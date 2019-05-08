package com.ylf.string;

import org.junit.Test;

/**
 * KMP算法
 * next[j]取决于其max(前缀==后缀)
 */
public class KMP {
     public int[] getNext(String pattern){
          int[] next=new int[pattern.length()];
          next[0]=0;
          for(int i=1,j=0;i<pattern.length();i++){
              while(j>0&&pattern.charAt(i)!=pattern.charAt(j)){
                  j=next[j-1];
              }
              if(pattern.charAt(i)==pattern.charAt(j)){
                  j++;
              }
              next[j]=j;
          }
          return next;
     }

     public int getIndex(String master,String pattern){
         int[] next=getNext(pattern);
         for(int i=0,j=0;i<master.length();i++){
             while(j>0&&master.charAt(i)!=pattern.charAt(j)){
                 j=next[j];
             }
             if(master.charAt(i)==pattern.charAt(j)){
                 j++;
             }
             if(j==pattern.length()){
                 return i-j+2;
             }
         }
         return 0;
     }

     @Test
    public void test(){
         int index=new KMP().getIndex("abcc","cc");
         System.out.println(index);
     }
}
