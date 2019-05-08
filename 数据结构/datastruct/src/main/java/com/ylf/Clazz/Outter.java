package com.ylf.Clazz;

public class Outter {
    int i=0;
    static int j=1;
    public  static void  main(String[] args){
       System.out.println(Inner.m);
    }
     static  class Inner{
       static int m=3;
         int n=4;

    }
}
