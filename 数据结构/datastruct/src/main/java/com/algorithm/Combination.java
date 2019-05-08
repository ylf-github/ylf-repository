package com.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 全组合(不包括全不选)、集合全部子集(不包括空集)
 * 利用位图进行运算(abc,011代表bc,100代表a,即1为取0为不取)
 */
public class Combination {

    public static void main(String[] args) {
        combination("abcc");
    }

    public static void combination(String s) {
        ArrayList<String> list=new ArrayList<>();
        Set set=new LinkedHashSet();
        char[] strs = s.toCharArray();
        String k="";
        int n = s.length();
        int count = 1 << n;    //全部2^n种结果
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < n; j++) { //每种结果(二进制)与数组下标的每一位取与，为1则证明子集存在当前下标所对应的元素
                int tmp = 1 << j;         //定位到数组的每一个下标
                if ((tmp & i) != 0) {   //可利用!=0的次数来控制组合方式即C几几，并非全组合
                   // System.out.print(strs[j]);
                    k=k.concat(""+strs[j]);
                }
            }
            set.add(k);       //利用set去重
            k="";
        }
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
