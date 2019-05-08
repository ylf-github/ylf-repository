package com;

import org.junit.Test;

public class CodeThree {

    @Test
    public void test(){
        String s1="abc";
        String s2="badc";
        System.out.println(getResult(s1,s2));
    }

    public static int min(int a,int b,int c){
        int t=a<b?a:b;
        return t<c?t:c;
    }

    public int getResult(String s1,String s2){
        int[][] table=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            table[i][0]=i;
        }
        for(int j=0;j<=s2.length();j++){
            table[0][j]=j;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int value=(s1.charAt(i-1)==s2.charAt(j-1)?0:1);
                int add=table[i-1][j]+1;            //增加
                int del=table[i][j-1]+1;            //删除
                int repalce=table[i-1][j-1]+value;  //替换
                table[i][j]=min(add,del,repalce);
            }
        }
        return table[s1.length()][s2.length()];
    }
}
