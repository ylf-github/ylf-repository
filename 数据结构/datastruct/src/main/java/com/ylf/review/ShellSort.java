package com.ylf.review;

import org.junit.Test;
/**
 * 希尔排序
 * 最坏O(n^2)
 * T(1)
 * 不稳定
 */
public class ShellSort {
    int[] array=new int[]{0,3,2,9,5,7,8,6};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void sort(int[] arg){
         int n=arg.length;
         int d=n/2;
         while (d>0){
             for(int i=d;i<n;i++){
                 int j=i-d;      //组内指针
                 while(j>=0&&arg[j+d]>arg[j]){
                     int temp=arg[j];
                     arg[j]=arg[j+d];
                     arg[j+d]=temp;
                     j-=d;       //用于跳出循环
                 }
             }
             d/=2;
         }
    }
    @Test
    public void testSort(){
        sort(array);
        print();
    }
}
