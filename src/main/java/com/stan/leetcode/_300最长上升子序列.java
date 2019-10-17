package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _300最长上升子序列 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,1,7,8,9};
//        System.out.println(new Solution_300().lengthOfLIS2(arr));

        System.out.println(new Solution_300().LISDetail(arr));


    }
}
class Solution_300 {

    /**
     * 动态规划
     * for循环中维护4个变量：
     *      dp_len[i]：0到i位取lis，以i为结尾能取到的最大长度
     *      pre[i]：本次以i为结果，存上一个过来的位置
     *      result：遍历到目前的最大长度
     *      index：遍历到目前的最长lis序列的最后一位索引
     *
     * @param nums
     * @return： 返回最长上升子序列的具体list
     */
    public ArrayList<Integer> LISDetail(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        int[] dp_len = new int[nums.length];
        int[] pre = new int[nums.length];

        Arrays.fill(dp_len, 1);  //初始化
        Arrays.fill(pre, -1);    //初始化
        int result = 1;
        int index = 0;
        for(int i = 1; i < nums.length; ++i) {

            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp_len[j] + 1 > dp_len[i]) {
                    dp_len[i] = dp_len[j] + 1;
                    pre[i] = j;
                }
            }
            //更新lis序列的最后一位索引
            if(result < dp_len[i]) {
                result = dp_len[i];
                index = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (index >= 0) {
            res.add(nums[index]);
            index = pre[index];
        }
        Collections.reverse(res);
        return res;
    }




    /**
     * 动态规划
     * dp[i] 表示 以i位结尾的最长上升子序列的长度
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {

        int N = nums.length;
        if (N <= 1) return N;
        int[] dp = new int[N];
        int res = 0;
        for (int i = 0; i < N; ++i) {
            dp[i] = 1;   //最差就
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }





    /**
     * 二分法
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length <= 1) return nums.length;

        int[] lis = new int[nums.length];
        lis[0] = nums[0];
        int i = 1;
        for (int j = 1; j < lis.length; j++) {
            if (nums[j] > lis[i - 1]) lis[i++] = nums[j];  //比lis最右边那个还大，就直接拷过去
            else {
                int insert_index = binarySearch(lis, 0, i - 1, nums[j]);  //找到插入位置
                lis[insert_index] = nums[j];    //保证lis升序的同时，未雨绸缪
            }
        }
        return i;
    }


    //二分查找，同样的值，会插在前面
    public int binarySearch(int[] nums, int head, int tail, int target) {

        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) head = mid + 1;
            else tail = mid - 1;
        }
        return head;
    }
}