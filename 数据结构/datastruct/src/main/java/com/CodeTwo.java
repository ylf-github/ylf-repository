package com;

import org.junit.Test;

public class CodeTwo {

    @Test
    public void test(){
        String test="2,3,1";
        System.out.println(getResult(test));
    }

    private static int getResult(String arg)
    {
        String s[] = arg.split(",");
        int a[] = new int[s.length];
        int count =0;
        for(int i=0;i<a.length;i++)
        {
            a[i]=Integer.valueOf(s[i]);
        }
        for(int i = 0;i<a.length;i++)   //依次寻找个元素的逆序数次数
        {
            for(int j =i+1;j<a.length;j++)
            {
                if(a[i]>a[j])           //如果是逆序数则次数加一
                    count++;
            }
        }
        return count;
    }

}
