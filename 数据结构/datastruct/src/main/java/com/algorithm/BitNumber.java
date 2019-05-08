package com.algorithm;


import java.util.Scanner;

/**
 * 计算两个很大的数的和
 */
public class BitNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1=in.next();
        String s2=in.next();
        add(s1,s2);
    }

    public static void add(String s1,String s2){
        String l=s1.length()>s2.length()?s1:s2;
        String s=s1.length()>s2.length()?s2:s1;
        int distance=l.length()-s.length();
        for(int i=0;i<distance;i++){
            s="0".concat(s);
        }
        int flag=0;
        int c;
        int[] result=new int[s.length()+1];
        for(int i=s.length()-1;i>=0;i--){
            if(flag==1){
                 c=Integer.valueOf(s.charAt(i)+"")+Integer.valueOf(l.charAt(i)+"")+1;
                 flag=0;
            }
            else{
                 c=Integer.valueOf(s.charAt(i)+"")+Integer.valueOf(l.charAt(i)+"");
            }
            if(c>=10){
                flag=1;
                result[i+1]=c%10;
                if(i==0){
                    result[i]=1;
                }
            }
            else{
                result[i+1]=c;
            }
        }

        for(int i=0;i<result.length;i++){
            if(i==0&&result[i]==0)
                continue;
            System.out.print(result[i]);
        }
    }
}
