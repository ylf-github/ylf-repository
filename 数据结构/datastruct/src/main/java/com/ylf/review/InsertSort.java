package com.ylf.review;

import org.junit.Test;

/**
 * 插入排序
 * 最坏O(n^2)
 * T(1)
 * 稳定
 */
public class InsertSort {
    int[] array=new int[]{4,3,2,7,5,9,8,6};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void sort(int[] arg){
        for(int i=1;i<arg.length;i++){
            int k=i;
            while(k>0&&arg[k-1]<arg[k]){
                int temp=arg[k-1];
                arg[k-1]=arg[k];
                arg[k]=temp;
                k--;
            }
        }
    }

    @Test
    public void testSort(){
        sort(array);
        print();
    }

}
