package com.ylf.review;

import org.junit.Test;

/**
 * 选择排序
 * 最坏O(n^2)
 * T(1
 * 不稳定
 */
public class SelectSort {
    int[] array=new int[]{1,4,2,9,5,7,8,6};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public void sort(int[] arg){
        for(int i=0;i<arg.length-1;i++){
            int index=i;
            for(int j=i+1;j<arg.length;j++){
               if(arg[j]>arg[index]){
                   index=j;
               }
            }
            if(index>i){
                int temp=arg[i];
                arg[i]=arg[index];
                arg[index]=temp;
            }
        }

    }

    @Test
    public void testSort(){
        sort(array);
        print();
    }
}
