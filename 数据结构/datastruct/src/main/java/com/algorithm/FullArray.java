package com.algorithm;


public class FullArray {

    /**
     *  思路：此程序是在全排列的基础上修改的。
     *      1.掌握全排列后
     *      2.添加条件：如果在arrays[i]前面含有　arrays[j] == arrays[i] 则不进行排列，否则进行排列。
     */

    public static void permutation(int[] arrays, int left, int right) {
        if (left == right) {
            for (int key : arrays) {
                System.out.print(key);
            }
            System.out.println();
        } else {
            for (int i = left; i <= right; i++) {
                if (!isExit(arrays, left, i)) {
                    swap(arrays, left, i);
                    permutation(arrays, left+1, right);
                    swap(arrays, left, i);
                }
            }
        }
    }

    public static void swap(int[] arrays, int leftValue, int rightValue) {
        int tempValue = arrays[leftValue];
        arrays[leftValue] = arrays[rightValue];
        arrays[rightValue] = tempValue;
    }

    public static boolean isExit(int[] arrays, int left, int index) {
        int key = arrays[index];
        for (int i = left; i < index; i++) {
            if (key == arrays[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 2};
        permutation(arrays, 0, arrays.length-1);
    }
}