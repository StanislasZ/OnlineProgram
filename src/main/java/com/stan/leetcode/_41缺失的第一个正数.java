package com.stan.leetcode;

public class _41缺失的第一个正数 {

    /**
     * 遍历一次，<= 0或 >N 的，continue
     * 在范围内的，比如值=4， 索引为3的位置应该是放4
     * 如果a[3] != 4 就交换过去，再看换过来的当前值，循环
     *
     *
     * 和牛客的一题有点像，用交换法
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            //比如 nums[i] =4 那么4应该被放在索引为 3的地方， 因为理想情况是 1 2 3 4对应索引 0 1 2 3
            //一旦索引为3处的value != 4, 就换过去
            //终止条件为 当前值不在范围内，或 目标位置已经是正确的数
            while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }

        return N + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] a= new int[]{1,1};
        System.out.println(new _41缺失的第一个正数().firstMissingPositive(a));
    }
}
