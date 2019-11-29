package com.stan.leetcode;


/**
 * 和某个公司的一道发年终奖的题差不多
 */
public class _135分发糖果 {

    public int candy(int[] ratings) {

        int[] nums = new int[ratings.length];

        //向右遍历一趟，仅保留一半的规则，对某个，只比较它和它的左边
        //即 针对某一个，if 它 > 它左边 ， 要比左边那个多发一个
        //否则， 就发一个
        //因为这里只有一半的规则，最终结果的nums[i]一定>= 现在这里的nums[i]
        nums[0] = 1;
        for (int i = 1; i < nums.length; ++ i) {
            if (ratings[i] > ratings[i - 1]) nums[i] = nums[i - 1] + 1;
            else nums[i] = 1;
        }

        //再从右向左遍历一次
        //也是保留一半的规则，对某个，只比较它的它的右边
        //但是不能只这样，不然不就白搞了吗
        //怎么利用第一趟遍历的结果
        //加上 Math.max(第一趟遍历时赋的值，这次只看右边得出的值)
        for (int i = nums.length - 2; i >= 0; -- i) {
            if (ratings[i] > ratings[i + 1]) nums[i] = Math.max(nums[i], nums[i + 1] + 1);
            else nums[i] = Math.max(nums[i], 1);
        }


        //返回数组和
        int res = 0;
        for (int ele : nums) res += ele;
        return res;
    }
}
