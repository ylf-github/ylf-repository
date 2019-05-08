package com.ylf.review;

import org.junit.Test;

/**
 * 快速排序
 * 最坏O(n^2)
 * T(nlogn)
 * 不稳定
 */
public class QuickSort {
    int[] array=new int[]{3,1,2,9,5,7,8,6,11,22,90,23,25,43,21,74};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public int qkPass(int[] arg,int low,int high){
        int temp=arg[low];
            while(low<high){
            while(low<high&&arg[high]<=temp){
                high--;
            }
            arg[low]=arg[high];
            while(low<high&&arg[low]>temp){
                low++;
            }
            arg[high]=arg[low];
        }
        arg[low]=temp;
        return low;
    }

    public void qkSort(int[] arg,int low,int high){
        if(low<high+4){  //快排的优化，小数组是插入排序比较快
            InsertSort.sort(arg);
            return;
        }
        if(low<high){
            int pos=qkPass(arg,low,high);
            qkSort(arg,low,pos-1);
            qkSort(arg,pos+1,high);
        }
    }

    @Test
    public void testQkSort(){
        qkSort(array,0,array.length-1);
        print();
    }
}
