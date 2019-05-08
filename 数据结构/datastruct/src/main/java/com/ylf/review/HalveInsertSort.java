package com.ylf.review;

import org.junit.Test;
/**
 * 折半插入排序
 * 最坏O(n^2)
 * T(1)
 * 稳定
 */
public class HalveInsertSort {
    int[] array=new int[]{4,3,2,7,5,9,8,6};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void sort(int[] arg){
         for(int i=1;i<arg.length;i++){
             int temp=arg[i];
             int low=0;
             int high=i-1;
             while(low<=high){
                 int mid=(low+high)/2;
                 if(arg[i]>arg[mid]){
                     high=mid-1;
                 }
                 else {
                     low=mid+1;
                 }
             }
             for (int j=i-1;j>=low;j--){
                      arg[j+1]=arg[j];
             }
             arg[low]=temp;
         }
    }

    @Test
    public void testSort(){
        sort(array);
        print();
    }
}
