package com.stan.lintcode;

public class _77最长上升子序列 {
    public static void main(String[] args) {

    }
}
class Solution_最长上升子序列 {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {

        //LIS需要的二分查找插入位置 必须是 一样的数字要插在最前面！！！！！
        //未雨绸缪法

        if (nums.length <= 1) return nums.length;

        int[] lis = new int[nums.length];

        lis[0] = nums[0];
        int i = 0;  //lis的最后一个位置
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] > lis[i]) {
                //比lis最后一个还大，直接加
                lis[++i] = nums[j];
            } else {
                int insertIndex = searchInsert(lis, 0, i, nums[j]);
                lis[insertIndex] = nums[j];
            }
        }
        return i + 1;

    }

    //查找插入位置
    public int searchInsert(int[] nums, int head, int tail, int target) {

        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) {
                head = mid + 1;
            } else {
                //相等归入这里，若有相同数字，最终的插入位置是最前面
                tail = mid - 1;
            }
        }
        return head;
    }

}
