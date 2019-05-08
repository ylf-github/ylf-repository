package com.algorithm;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 全排列、去重
 */
public class Permutations {

    static Set set=new LinkedHashSet();
    static String k="";

     public static void main(String[] args) {
        char[] s = {'c','a','a'};
        permutation(s, 0, 2);
         Iterator iterator=set.iterator();
         while(iterator.hasNext()){
             System.out.println(iterator.next());
         }
    }

        public static void permutation(char[] s,int from,int to) {
            if(from == to) {
                //System.out.println(s);
                for(char c:s)            //利用set去重
                    k=k.concat(""+c);
                set.add(k);
               k="";
            } else {
                for(int i=from; i<=to; i++) {
                   // if(isSwap(s,from,i)) {  //如果s[i]->s[j]中已有与s[j]相等的则跳过，因为其已在第一个位置过了
                        swap(s,i,from); //交换前缀，使其产生一个前缀
                        permutation(s, from+1, to);//递归全排列后续字串
                        swap(s,i,from); //不然会将已将在第一个位置出现过的元素再次放到第一个位置产生错误
                  //  }
                }
            }
        }

        public static boolean isSwap(char[] s,int i,int j) {
            for(int k=i; k<j; k++) { //如果s[i]->s[j]中已有与s[j]相等的则跳过，因为其已在第一个位置过了
                if(s[k]==s[j])
                    return false;
            }
         return true;
        }

    public static void swap(char[] s,int i,int j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }

}



