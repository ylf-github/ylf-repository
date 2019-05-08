package com.ylf.review;

import org.junit.Test;

/**
 * 归并排序
 * 最坏O(nlogn)
 * T(n)
 * 稳定
 */
public class MergeSort {
    int[] array=new int[]{3,1,2,9,5,7,8,6};

    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void merge(int[] arg,int left,int mid,int right){
        int temp[]=new int[arg.length];
        int point1=left;
        int point2=mid+1;
        int t=left;
        while(point1<=mid&&point2<=right){
            if(arg[point1]>=arg[point2]){
                temp[t++]=arg[point1++];
            }
            else {
                temp[t++]=arg[point2++];
            }
        }
        while(point1<=mid){
            temp[t++]=arg[point1++];
        }
        while(point2<=right){
            temp[t++]=arg[point2++];
        }
        for(int i=left;i<=right;i++){   //复制回去
            arg[i]=temp[i];

        }
    }
    public void sort(int[] arg,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            sort(arg,left,mid);
            sort(arg,mid+1,right);
            merge(arg,left,mid,right);
        }
    }
    @Test
    public void testSort(){
        sort(array,0,array.length-1);
        print();
    }
}

