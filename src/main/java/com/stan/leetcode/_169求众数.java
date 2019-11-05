package com.stan.leetcode;

public class _169求众数 {

    /*
        给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

        你可以假设数组是非空的，并且给定的数组总是存在众数。

        示例 1:

        输入: [3,2,3]
        输出: 3
        示例 2:

        输入: [2,2,1,1,1,2,2]
        输出: 2

     */


    public int majorityElement(int[] nums) {

        int cnt = 0;
        int ref = 0;  //随便弄个值初始化
        for (int ele : nums) {
            if (cnt == 0)
                ref = ele;   //前面的刚好一一消掉，当前的作为比较对象

            if (ele == ref) ++ cnt;
            else -- cnt;
        }
        return ref;
    }
}
