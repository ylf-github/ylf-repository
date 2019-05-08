package com.ylf.DynamicProxy;

import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Advice implements InvocationHandler {
    private Object obj;

    public Advice(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName()+"1230");
        System.out.println("before method "+method.getName());
        System.out.println("args "+args[0]+" "+args[1]);
         int n=(int) method.invoke(obj,args[0],args[1]);
        System.out.println("after method");
        return n;
    }
}
