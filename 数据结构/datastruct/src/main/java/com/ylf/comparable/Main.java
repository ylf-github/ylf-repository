package com.ylf.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int i=0;i<n;i++){
            int t1=in.nextInt();
            list1.add(t1);
        }
        for(int i=0;i<n;i++){
            int t2=in.nextInt();
            list2.add(t2);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int i=0,j=0,x=n-1,y=n-1,count=0;
        boolean bLast=true;

        while(bLast)
        {
            if(x==i)
                bLast=false;
            if(list1.get(x)>list2.get(y)){
                x--;
                y--;
                count+=100;
            }
            else if(list1.get(i)>list2.get(j)){
                i++;
                j++;
                count+=100;
        }
            else{
                if(list1.get(i)<list2.get(y))
                    count-=100;
                i++;
                y--;
            }
        }
        System.out.println(count);
    }
}
