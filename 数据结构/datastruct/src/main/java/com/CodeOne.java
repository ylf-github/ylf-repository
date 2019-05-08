package com;

import org.junit.Test;

import java.util.HashMap;

public class CodeOne {

    @Test
    public void test(){
        int[] d=new int[]{54,55,300,12,56};
        System.out.println(getResult(d));
    }

    public int getResult(int[] data) {
        if(data.length==0)
            return 0;
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:data){
            if(map.getOrDefault(i,0)==0){  //已经出现过的值key直接跳过
                int left = map.getOrDefault(i-1,0);
                int right = map.getOrDefault(i+1,0);
                map.put(i,left+right+1);
                if(left!=0){              //更新左边界值
                    map.put(i-left,left+right+1);
                }
                if(right!=0){             //更新有边界值
                    map.put(i+right,right+left+1);
                }
                max = max>(left+right+1)?max:(left+right+1); //更新max值
            }
        }
        return max;
    }
}

