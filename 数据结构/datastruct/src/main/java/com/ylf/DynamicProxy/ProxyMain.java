package com.ylf.DynamicProxy;

import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args){

        Target target=new Target();
        Advice advice=new Advice(target);
        Add proxy=(Add) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),advice);
        System.out.println(target.getClass().getName());
        System.out.println(proxy.getClass().getName());
        int n=proxy.add(1,3);
        System.out.println(n);

    }
}
