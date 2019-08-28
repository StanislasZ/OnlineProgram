package com.stan.leetcode;

public class 下一个排列 {
    public static void main(String[] args){
        /*
            实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

            如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

            必须原地修改，只允许使用额外常数空间。

            以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
            1,2,3 → 1,3,2
            3,2,1 → 1,2,3
            1,1,5 → 1,5,1
         */

        int[] nums = { 2,6,3,2,1 };
        new Solution_31().nextPermutation(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
class Solution_31 {

    public void nextPermutation(int[] nums) {

        int len = nums.length;
        if (len == 1) return;

        //先从最右边向左搜索，找到第一次下降
        int i=nums.length-1;
        while(i-1>=0&&nums[i]<=nums[i-1]){
            i--;
        }
        System.out.println("i="+i);
        i--;
        if(i>=0){
            int j = nums.length-1;
            while(j>=0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse_right_part(nums,i+1);

    }

    //反转从left_index到最后这部分的数
    private void reverse_right_part(int[] nums,int left_index){
        int l=left_index;
        int r=nums.length-1;
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
