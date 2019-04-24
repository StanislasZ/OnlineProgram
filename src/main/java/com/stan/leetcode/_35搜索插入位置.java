package com.stan.leetcode;

public class _35搜索插入位置 {
    public static void main(String[] args) {



    }
}


class Solution_35 {




    public int searchInsert(int[] nums, int target) {

        int head = 0;
        int tail = nums.length - 1;


        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) {
                head = mid + 1;
            }else if (nums[mid] > target) {
                tail = mid - 1;
            }else {
                return mid;
            }

            //下面是  1 2 2 2 3 4返回索引是1 ，插在前面
//            if (nums[mid] < target) head = mid + 1;
//            else tail = mid - 1;


            //下面是 1 2 2 2 3 4返回索引是4，插在后面
//            if (nums[mid] > target) tail = mid - 1;
//            else head = mid + 1;

        }
        return head;




    }





}