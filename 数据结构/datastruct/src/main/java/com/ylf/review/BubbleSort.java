package com.ylf.review;

import org.junit.Test;

/**
 * 冒泡排序
 * 最坏O(n^2)
 * T(1)
 * 稳定
 */
public class BubbleSort {
    int[] array=new int[]{1,3,2,9,5,7,8,6};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public void sort(int[] arg){
        for(int i=0;i<arg.length-1;i++) {
            for(int j=0;j<arg.length-1-i;j++){
                if(arg[j]<arg[j+1]){
                    int temp=arg[j+1];
                    arg[j+1]=arg[j];
                    arg[j]=temp;
                }
            }
        }
    }
    @Test
    public void testSort(){
        sort(array);
        print();
    }
}

