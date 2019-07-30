package com.stan.nowcoder;

import java.util.ArrayList;

public class 和为S的两个数字 {

    /*
        输入一个递增排序的数组和一个数字S，
        在数组中查找两个数，使得他们的和正好是S，
        如果有多对数字的和等于S，输出两个数的乘积最小的。
     */


    ArrayList<Integer> res = new ArrayList<>();


    /**
     * 双指针
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left] + array[right];
            if (temp == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            } else if (temp < sum) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
