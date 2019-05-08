package com.ylf.string;

import org.junit.Test;

/**
 * 暴力匹配算法
 */
public class Force {
    public int BF(String master,String model,int pos){
        int i=pos;
        int j=0;
        while(i<master.length()&&j<model.length()){
            if(master.charAt(i)==model.charAt(j)){
                i++;
                j++;
            }
            else{
                i=i-j+1;
                j=0;
            }
            if(j==model.length()){
                return i-j+1;
            }
        }
        return 0;
    }

    @Test
    public void bF(){
        int n=new Force().BF("abccbs","cc",0);
        System.out.println(n);
    }
}
