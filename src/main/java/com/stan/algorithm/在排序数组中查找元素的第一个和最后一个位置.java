package com.stan.algorithm;

public class 在排序数组中查找元素的第一个和最后一个位置 {


    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = new Solution_34().searchRange(nums, target);

        System.out.println("result is "+ result[0]+ "," + result[1]);
    }





}
class Solution_34 {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0||target < nums[0] || target > nums[nums.length - 1]){
            return new int[]{-1 , -1};
        }

        //int[] res = new int[2];

        int left = 0;
        int right = nums.length;
        int mid = (left + right)/2;

        int oneRes = binSearch(nums, 0, nums.length-1, target);
        if(oneRes == -1){
            return new int[]{-1 , -1};
        }else{

            int a = oneRes;
            int b = oneRes;
            while(a>0 && nums[a-1] == target){
                a--;
            }
            while (b < nums.length-1 && nums[b + 1] == target) {
                b++;
            }
            return new int[]{a,b};



        }




    }



    public static int bs(int[] arr, int left ,int right, int target){

        int mid = (right - left) /2 + left;
        if(arr[mid] == target){
            return mid;
        }


        if(left >= right){  //这个判断容易忘记！！！！
            return -1;
        }

        if(arr[mid] > target){
            return bs(arr, left,mid -1, target);
        }else{
            return bs(arr, mid+1, right, target);
        }






    }

    // 二分查找递归实现
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }



}