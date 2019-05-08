package com.ylf.DynamicProxy;

/**
 * 目标对象
 */
public class Target implements Add{
    public int add(int x,int y){
        return x+y;
    }
}
